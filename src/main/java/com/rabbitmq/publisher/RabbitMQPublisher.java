package com.rabbitmq.publisher;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class RabbitMQPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);
    @Value("${rabbitmq.exchange.name}")
    public String exchangeName;
    @Value("${rabbitmq.routing.key}")
    public String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        LOGGER.info("Message Send -------------> " + message);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
