package com.demo.kafka.springbootkafkaproducerdemo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserResource {

    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;
    private static final String Topic = "SimpleProducerTopic";

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message){


        KafkaTemplate.send(Topic, message);

        return "Published successfully";
    }
}
