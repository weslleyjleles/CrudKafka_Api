package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import br.com.ProjetoEstudo.crudkafkaapi.messages.PostMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PostListener {

    private final Logger logger = LoggerFactory.getLogger(PostListener.class);

    @KafkaListener(topics = "Postagem", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "PostContainerFactory")
    public void PostListener(PostMessage message) {
        logger.info("\n Post Kafka Listener received value: \n {}", message.getDataHoraPublicacao());
    }
}
