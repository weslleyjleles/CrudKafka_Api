package br.com.ProjetoEstudo.crudkafkaapi.listeners;

import br.com.ProjetoEstudo.crudkafkaapi.messages.ImageMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ImageListener {
    private final Logger logger = LoggerFactory.getLogger(ImageListener.class);

    @KafkaListener(topics = "Imagem", groupId = "CONSUMER_APPLICATION_EXAMPLE_GROUP", containerFactory = "ImageContainerFactory")
    public void ImageListener(ImageMessage message) {
        logger.info("\n Image Kafka Listener received value: \n {}", message.getAcaoImagem());
    }
}
