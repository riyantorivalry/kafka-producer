package com.technolins.kafka.producer.controller;

import com.technolins.kafka.producer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/producer")
public class UserController {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplateUser;
    private static final String TOPIC = "kafkatopic";

    @GetMapping("/{name}/{city}")
    public String getUser(@PathVariable("name") String name, @PathVariable("city") String city ){
        kafkaTemplateUser.send(TOPIC, new User(name, city));
        return "Message sent successfully";
    }
}
