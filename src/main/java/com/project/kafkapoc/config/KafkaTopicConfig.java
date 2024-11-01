package com.project.kafkapoc.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.project.kafkapoc.constants.Constants.KAFKA_JSON_TOPIC;
import static com.project.kafkapoc.constants.Constants.KAFKA_TOPIC;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafka1Topic(){
        return TopicBuilder.name(KAFKA_TOPIC).build();
    }

    @Bean
    public NewTopic kafka1JsonTopic(){
        return TopicBuilder.name(KAFKA_JSON_TOPIC).build();
    }
}
