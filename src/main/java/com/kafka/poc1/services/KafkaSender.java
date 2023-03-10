package com.kafka.poc1.services;

import com.kafka.poc1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${spring.kafka.topicName}")
    private String topicName;

    public KafkaSender(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(Product product) {
        Message<Product> productMessage = MessageBuilder.withPayload(product)
                .setHeader(KafkaHeaders.TOPIC,topicName)
                .build();
        kafkaTemplate.send(productMessage);
        return "Success";
    }



}
