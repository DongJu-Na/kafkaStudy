package com.kafkaStudy.ndj.producer;

import com.kafkaStudy.ndj.entity.Message;
import com.kafkaStudy.ndj.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "testTopic";
    private final  KafkaTemplate<String, String> kafkaTemplate;
    private final MessageRepository messageRepository;

    public void sendMessgae(String message) {
        System.out.printf("Produce message : %s%n", message);


        CompletableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC, message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Message sent successfully > " + result);
                Message messageEntity = Message.builder()
                        .message(result.getProducerRecord().value())
                        .regDttm(LocalDateTime.now())
                        .regUserId("api")
                        .build();

                messageRepository.save(messageEntity);
            } else {
                System.out.println("Error sending message " + ex);
            }
        });
    }
}