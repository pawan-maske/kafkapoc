package com.project.kafkapoc.kafka;

import com.project.kafkapoc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.project.kafkapoc.constants.Constants.KAFKA_JSON_TOPIC;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics =KAFKA_JSON_TOPIC, groupId = "myGroup")
    public void consume(User user){
        log.info(String.format("Received JSON Message -> %s", user.toString()));
    }
}
