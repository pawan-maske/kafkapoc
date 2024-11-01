package com.project.kafkapoc.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.project.kafkapoc.constants.Constants.KAFKA_TOPIC;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message Received -> %s", message));
    }
}
