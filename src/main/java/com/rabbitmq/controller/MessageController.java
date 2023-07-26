package com.rabbitmq.controller;

import com.rabbitmq.publisher.RabbitMQPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    private RabbitMQPublisher rabbitMQPublisher;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMQPublisher.sendMessage(message);
        return ResponseEntity.ok("Message Send to RabbitMq ...");
    }
}
