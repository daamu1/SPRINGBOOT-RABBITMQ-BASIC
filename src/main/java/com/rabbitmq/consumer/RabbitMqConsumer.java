package com.rabbitmq.consumer;

import com.rabbitmq.publisher.RabbitMQPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);


    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumeMessage(String message) {
        LOGGER.info(String.format("Recieved Message -------------> " + message));
    }

}
