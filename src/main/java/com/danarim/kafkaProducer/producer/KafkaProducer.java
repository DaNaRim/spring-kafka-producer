package com.danarim.kafkaProducer.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.danarim.kafkaProducer.config.KafkaTopicConfig.TOPIC_TOPIC1;

@Service
public class KafkaProducer {

    private static final Log log = LogFactory.getLog(KafkaProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info(String.format("$$ -> Producing message --> %s", message));
        kafkaTemplate.send(TOPIC_TOPIC1, message);
    }

}
