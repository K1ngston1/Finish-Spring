package com.example.demo.config.service;

import com.example.demo.config.model.AppointmentMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentKafkaProducer {

    private final KafkaTemplate<String, AppointmentMessage> kafkaTemplate;

    public AppointmentKafkaProducer(KafkaTemplate<String, AppointmentMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(AppointmentMessage message) {
        kafkaTemplate.send("appointment-topic", message);
    }
}