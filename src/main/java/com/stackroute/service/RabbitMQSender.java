package com.stackroute.service;

import com.stackroute.domain.Neo4jObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${neo4j.exchange.name}")
    private String exchange;

    @Value("${neo4j.routing.key}")
    private String routingkey;

    public void send(Neo4jObject token) {
        rabbitTemplate.convertAndSend(exchange, routingkey, token);
        System.out.println("Send msg = " + token);
    }
}
