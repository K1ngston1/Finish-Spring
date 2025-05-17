package com.example.demo.config.component;

import com.example.demo.config.model.AppointmentMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AppointmentKafkaConsumer {

    @KafkaListener(topics = "appointment-topic", groupId = "appointment-group")
    public void listen(AppointmentMessage message) {
        System.out.println("Отримано повідомлення: " + message.getAppointmentId());
    }
}
