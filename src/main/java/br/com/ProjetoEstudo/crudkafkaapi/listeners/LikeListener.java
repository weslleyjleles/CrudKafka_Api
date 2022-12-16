package br.com.ProjetoEstudo.crudkafkaapi.listeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.ProjetoEstudo.crudkafkaapi.messages.LikeMessage;
@Component
public class LikeListener {


    private final Logger logger = LoggerFactory.getLogger(LikeListener.class);

    @KafkaListener(topics = "Like", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "LikeContainerFactory")
    public void LikeListener(LikeMessage message) {
        logger.info("\n Like Kafka Listener received value: \n {}", message.getAcaoLike());
    }
}
	

