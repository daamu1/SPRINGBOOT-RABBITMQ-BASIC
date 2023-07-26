package com.rabbitmq.consumer;

import com.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJasonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJasonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.jason.name}"})
    public void consumeMessage(User user) {
        LOGGER.info(String.format("User jason recieved-------------> " + user.toString()));
    }
}
