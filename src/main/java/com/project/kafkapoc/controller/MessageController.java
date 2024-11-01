package com.project.kafkapoc.controller;

import com.project.kafkapoc.kafka.JsonKafkaProducer;
import com.project.kafkapoc.kafka.KafkaProducer;
import com.project.kafkapoc.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;
    private JsonKafkaProducer jsonKafkaProducer;

    public MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    /**
     *
     * @param message that is to be sent
     * @return String
     */
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam(value = "message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("publish/user")
    public ResponseEntity<String> publishUser(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("User published successfully");
    }
}
