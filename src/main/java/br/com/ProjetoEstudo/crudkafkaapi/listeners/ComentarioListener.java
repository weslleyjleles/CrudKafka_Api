package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.ProjetoEstudo.crudkafkaapi.messages.ComentarioMessage;
@Component
public class ComentarioListener  {
    private final Logger logger = LoggerFactory.getLogger(ComentarioListener.class);

    @KafkaListener(topics = "Comentario", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "CommentContainerFactory")
    public void ComentarioListener(ComentarioMessage message) {
        logger.info("\n Comment Kafka Listener received value: \n {}", message.getAcaoComment());
    }
}
	
	
