package com.stackroute.controller;

import com.stackroute.domain.Neo4jObject;
import com.stackroute.domain.Node;
import com.stackroute.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private RabbitMQSender rabbitMQSender;
    @GetMapping("/send")
    public void sendMessage(){
        Neo4jObject obj = new Neo4jObject();
        obj.setName(new Node("name","Febin"));
        obj.setDateOfBirth(new Node("date-of-birth","12-02-1997"));
        obj.setGender(new Node("gender","male"));
        obj.setMotherTongue(new Node("mother-tongue","malayalam"));
        obj.setReligion(new Node("religion","christian"));
        obj.setCaste(new Node("caste","roman catholic"));
        obj.setHeight(new Node("height","172"));
        obj.setWeight(new Node("weight","72"));
        obj.setMobileNumber(new Node("mobile-no","9562123412"));
        rabbitMQSender.send(obj);
    }
}
