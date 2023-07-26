package com.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Value("${rabbitmq.queue.name}")
    private String queueName;
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    //Spring bean  for rabbitmq queue
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    //Spring bean  for rabbit mq exchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }

    //Binding queue with topic exchange  using routing key
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with(routingKey);
    }
    /*
    Required Bean
    1.ConnectionFactory
    2.RabbitTemplate
    3.RabbitAdmin
    Springboot autoconfiguration automatically configured this bean  for us
     */
}
