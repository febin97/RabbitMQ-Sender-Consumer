package com.stackroute.service;

import com.stackroute.domain.Neo4jObject;
import com.stackroute.domain.Node;
import com.stackroute.domain.Personal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {
    @Autowired
    RabbitMQSender sender;
    @RabbitListener(queues = "${personal.queue.name}")
    public void receiveMsg(Personal personalObject){
        System.out.println("Received Msg from Upstream"+" "+personalObject);
        Neo4jObject obj = new Neo4jObject();
        obj.setName(new Node("name",personalObject.getName()));
        obj.setDateOfBirth(new Node("date-of-birth",personalObject.getDateOfBirth()));
        obj.setGender(new Node("gender",personalObject.getGender()));
        obj.setMotherTongue(new Node("mother-tongue",personalObject.getMotherTongue()));
        obj.setReligion(new Node("religion",personalObject.getReligion()));
        obj.setCaste(new Node("caste",personalObject.getCaste()));
        obj.setHeight(new Node("height",String.valueOf(personalObject.getHeight())));
        obj.setWeight(new Node("weight",String.valueOf(personalObject.getWeight())));
        obj.setMobileNumber(new Node("mobile-no",personalObject.getMobileNumber()));
        sender.send(obj);
    }
}
