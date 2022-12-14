package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import br.com.ProjetoEstudo.crudkafkaapi.kafkamessages.usuarioMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class usuarioListener {
    private final Logger logger = (Logger) LoggerFactory.getLogger(usuarioListener.class);

    @KafkaListener(topics = "Usuario", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "userContainerFactory")
    public void userListener(usuarioMessage message) {
        logger.info("\n User Kafka Listener received value: \n {}", message.getNomeUsuario());
    }
}
