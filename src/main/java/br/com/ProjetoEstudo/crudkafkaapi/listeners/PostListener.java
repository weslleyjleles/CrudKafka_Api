package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import br.com.ProjetoEstudo.crudkafkaapi.messages.PostMessage;
import br.com.ProjetoEstudo.crudkafkaapi.model.Post;
import br.com.ProjetoEstudo.crudkafkaapi.model.Usuario;
import br.com.ProjetoEstudo.crudkafkaapi.repository.PostRepository;
import br.com.ProjetoEstudo.crudkafkaapi.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostListener {

    @Autowired
    private PostRepository repository;
    @Autowired
    private UsuarioRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(PostListener.class);

    @KafkaListener(topics = "Postagem", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "PostContainerFactory")
    public void PostListener(PostMessage message) {
        logger.info("\n Post Kafka Listener received value: \n {}", message.getDataHoraPublicacao());

        if (message.getAcaoPublicacao().equals("salvar") && message.getIdUsuario() != null
        && message.getDataHoraPublicacao() != null && message.getTituloPublicacao() != null
        && message.getTextoPublicacao() != null && message.getVisualisacaoPublicacao() == 0){
            Post post = new Post();

            post.setTitulo(message.getTituloPublicacao());
            post.setTexto(message.getTextoPublicacao());
            post.setVisualisacao(message.getVisualisacaoPublicacao());
            post.setDataHoraPublicacao(message.getDataHoraPublicacao());
            Optional<Usuario> user = userRepository.findById(message.getIdUsuario());
            if (user.isPresent()){
                post.setUsuario(user.get());
            }else {
                throw new RuntimeException("User not found!");
            }
            Post postDb = repository.save(post);
            System.out.println("Post de id: " + postDb.getId() + " salvo com sucesso!");
        }

        if (message.getAcaoPublicacao().equals("alterar") && message.getVisualisacaoPublicacao() != null){

            Optional<Post> postOptional = repository.findById(message.getIdPublicacao());

            if (postOptional.isPresent()){
                Post post = postOptional.get();
                if (message.getTituloPublicacao() != null && !message.getTituloPublicacao().isEmpty()){
                    post.setTitulo(message.getTituloPublicacao());
                }
                if (message.getTextoPublicacao() != null && !message.getTextoPublicacao().isEmpty()){
                    post.setTexto(message.getTextoPublicacao());
                }
                if (message.getVisualisacaoPublicacao() > post.getVisualisacao()) {
                    post.setVisualisacao(message.getVisualisacaoPublicacao());
                }
                Post postDb = repository.save(post);
                System.out.println("Post de id: " + postDb.getId() + " salvo com sucesso!");
            }else {
                throw new RuntimeException("Post id: "+message.getIdPublicacao()+" changed succesfully!");
            }

        }

        if (message.getAcaoPublicacao().equals("deletar") && message.getIdPublicacao() != null){
            repository.deleteById(message.getIdPublicacao());
            System.out.println("Post deleted succesfully id: " + message.getIdPublicacao());
        }
    }

}
