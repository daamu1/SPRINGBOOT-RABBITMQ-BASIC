package com.rabbitmq.publisher;

import com.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJasonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJasonProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.jason.key}")
    private String routingJasonKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJasonMessage(User user) {
        LOGGER.info("User jason send -------------> " + user.toString());
        rabbitTemplate.convertAndSend(exchangeName, routingJasonKey, user);
    }
}
