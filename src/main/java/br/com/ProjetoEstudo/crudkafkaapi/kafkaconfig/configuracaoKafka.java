package br.com.ProjetoEstudo.crudkafkaapi.kafkaconfig;

import br.com.ProjetoEstudo.crudkafkaapi.messages.ComentarioMessage;

import br.com.ProjetoEstudo.crudkafkaapi.messages.LikeMessage;

import br.com.ProjetoEstudo.crudkafkaapi.messages.PostMessage;

import br.com.ProjetoEstudo.crudkafkaapi.messages.UsuarioMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class configuracaoKafka {

    private <T> Map<String, Object> getProps(Class<T> consumerTypeClass) {
        Map<String, Object> props = new HashMap<>();

        // Obrigatorias
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // JSONSERIALIZER
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, consumerTypeClass);

        // Opcionais
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    @Bean(name = "userContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Integer, Object> userContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getProps(UsuarioMessage.class)));
        factory.getContainerProperties().setMissingTopicsFatal(false);
        factory.getContainerProperties().setSyncCommits(true);

        return factory;
    }

    @Bean(name = "CommentContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Integer, Object> CommentContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getProps(ComentarioMessage.class)));
        factory.getContainerProperties().setMissingTopicsFatal(false);
        factory.getContainerProperties().setSyncCommits(true);

        return factory;
    }

    @Bean(name = "LikeContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Integer, Object> LikeContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getProps(LikeMessage.class)));


    @Bean(name = "PostContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Integer, Object> PostContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Integer, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getProps(PostMessage.class)));

        factory.getContainerProperties().setMissingTopicsFatal(false);
        factory.getContainerProperties().setSyncCommits(true);

        return factory;

}
