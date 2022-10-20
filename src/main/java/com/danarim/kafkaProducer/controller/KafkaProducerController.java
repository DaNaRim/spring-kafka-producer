package com.danarim.kafkaProducer.controller;

import com.danarim.kafkaProducer.producer.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private final KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public String sendMessageToKafkaTopic(@RequestParam String message) {
        this.kafkaProducer.sendMessage(message);
        return "Message published successfully";
    }
}
