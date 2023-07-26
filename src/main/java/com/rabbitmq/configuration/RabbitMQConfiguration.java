package com.rabbitmq.configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMQConfiguration {
    @Value("${rabbitmq.queue.name}")
    private String queueName;
    @Value("${rabbitmq.queue.jason.name}")
    private String jasonQueueName;
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    @Value("${rabbitmq.routing.jason.key}")
    private String routingJasonKey;

    //Spring bean  for rabbitmq queue
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    //Spring bean for Queue(Store the jason message
    @Bean
    public Queue jasonQueue() {
        return new Queue(jasonQueueName);
    }

    //Spring bean  for rabbit mq exchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }

    //Binding queue with topic exchange  using routing key
    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    } //Binding Jason queue with topic exchange  using routing key
    @Bean
    public Binding bindingJson() {
        return BindingBuilder
                .bind(jasonQueue())
                .to(topicExchange())
                .with(routingJasonKey);
    }

    /*
    Required Bean
    1.ConnectionFactory
    2.RabbitTemplate
    3.RabbitAdmin
    Springboot autoconfiguration automatically configured this bean  for us
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
