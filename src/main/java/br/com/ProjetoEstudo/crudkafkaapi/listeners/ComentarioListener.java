package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.ProjetoEstudo.crudkafkaapi.messages.ComentarioMessage;
import br.com.ProjetoEstudo.crudkafkaapi.model.Comentario;
import br.com.ProjetoEstudo.crudkafkaapi.model.Post;
import br.com.ProjetoEstudo.crudkafkaapi.model.Usuario;
import br.com.ProjetoEstudo.crudkafkaapi.repository.ComentarioRepository;
import br.com.ProjetoEstudo.crudkafkaapi.repository.PostRepository;
import br.com.ProjetoEstudo.crudkafkaapi.repository.UsuarioRepository;

@Component
public class ComentarioListener {
	@Autowired
	private ComentarioRepository repository;
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	private final Logger logger = LoggerFactory.getLogger(ComentarioListener.class);

	@KafkaListener(topics = "Comentario", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "CommentContainerFactory")
	public void comentarioListener(ComentarioMessage message) {
		logger.info("\n Comment Kafka Listener received value: \n {}", message.getIdComment());

		if (message.getAcaoComment().equals("salvar") && message.getIdUsuario() != null
				&& message.getIdPublicacao() != null && message.getTextoComment() != null) {
			Comentario comment = new Comentario();

			comment.setTexto(message.getTextoComment());
			Optional<Usuario> userOptional = userRepository.findById(message.getIdUsuario());
			if (userOptional.isPresent()) {
				comment.setUsuario(userOptional.get());

			} else {
				throw new RuntimeException("User is not found");
			}
			Optional<Post> postOptional = postRepository.findById(message.getIdPublicacao());
			if (postOptional.isPresent()) {
				comment.setPost(postOptional.get());

			}else {
				throw new RuntimeException("Post is not found");
				
			} 
			repository.save(comment);
		}
		
		
		if (message.getAcaoComment().equals("deletar") && message.getIdComment() !=null){
			repository.deleteById(message.getIdComment());
			System.out.println("Comment deleted succesfully");
			
		}

	}

}