package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import br.com.ProjetoEstudo.crudkafkaapi.messages.UsuarioMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UsuarioListener {
    private final Logger logger = LoggerFactory.getLogger(UsuarioListener.class);

    @KafkaListener(topics = "user_topico", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "userContainerFactory")
    public void userListener(UsuarioMessage message) {
        logger.info("\n User Kafka Listener received value: \n {}", message);
    }
}
