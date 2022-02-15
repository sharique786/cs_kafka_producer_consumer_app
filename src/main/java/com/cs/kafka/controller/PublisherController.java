package com.cs.kafka.controller;

import com.cs.kafka.service.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublisherController {

    private final KafkaProducer kafkaProducer;

    public PublisherController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/{cityName}")
    public String publishMessage(@PathVariable("cityName") String cityName) {
        kafkaProducer.publish(cityName);
        return String.format("Json Data published For City [%s]", cityName);
    }
}
