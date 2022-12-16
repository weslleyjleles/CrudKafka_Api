package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import br.com.ProjetoEstudo.crudkafkaapi.messages.UsuarioMessage;
import br.com.ProjetoEstudo.crudkafkaapi.model.Usuario;
import br.com.ProjetoEstudo.crudkafkaapi.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioListener {
    @Autowired
    private UsuarioRepository repository;
    private final Logger logger = LoggerFactory.getLogger(UsuarioListener.class);

    @KafkaListener(topics = "Usuario", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "userContainerFactory")
    public void userListener(UsuarioMessage message) {
        logger.info("\n User Kafka Listener received value: \n {}", message.getNomeUsuario());

        if(message.getAcaoUsuario().equals("salvar") && message.getSenhaUsuario() != null && message.getNomeUsuario() != null
        && message.getEmailUsuario() != null && message.getUserUsuario() != null && message.getTelefoneUsuario() != null){
            Usuario usuario = new Usuario();

            usuario.setNome(message.getNomeUsuario());
            usuario.setEmail(message.getEmailUsuario());
            usuario.setUsername(message.getUserUsuario());
            usuario.setSenha(message.getSenhaUsuario());
            usuario.setTelefone(message.getTelefoneUsuario());

            repository.save(usuario);
        }

        if(message.getAcaoUsuario().equals("alterar") && message.getIdUsuario() != null
        && message.getSenhaUsuario() != null && message.getNomeUsuario() != null
        && message.getEmailUsuario() != null && message.getUserUsuario() != null
        && message.getTelefoneUsuario() != null){

            Optional<Usuario> user = repository.findById(message.getIdUsuario());
            if (user.isPresent()){
                Usuario usuario = new Usuario();

                usuario.setId(message.getIdUsuario());
                usuario.setNome(message.getNomeUsuario());
                usuario.setEmail(message.getEmailUsuario());
                usuario.setUsername(message.getUserUsuario());
                usuario.setSenha(message.getSenhaUsuario());
                usuario.setTelefone(message.getTelefoneUsuario());

                repository.save(usuario);
            }
        }

        if(message.getAcaoUsuario().equals("deletar") && message.getIdUsuario() != null){
            Usuario usuario = new Usuario();

            usuario.setId(message.getIdUsuario());

            repository.deleteById(usuario.getId());
        }

    }
}
