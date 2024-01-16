package com.kafkaStudy.ndj.producer;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "exam";
    private  KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(@SuppressWarnings("rawtypes") KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.printf("Produce message : %s%n", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}