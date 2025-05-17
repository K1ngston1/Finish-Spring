package com.example.demo.config.controller;

import com.example.demo.config.model.AppointmentMessage;
import com.example.demo.config.service.AppointmentKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaTestController {

    private final AppointmentKafkaProducer producer;

    public KafkaTestController(AppointmentKafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody AppointmentMessage msg) {
        producer.send(msg);
        return ResponseEntity.ok("Повідомлення надіслано.");
    }
}
