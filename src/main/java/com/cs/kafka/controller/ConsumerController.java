package com.cs.kafka.controller;

import com.cs.kafka.model.Country;
import com.cs.kafka.service.KafkaConsumer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private final KafkaConsumer kafkaConsumer;

    public ConsumerController(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("/consume")
    public ResponseEntity<Country> getPublishedCountries() {
       return new ResponseEntity<>(kafkaConsumer.getCountry(), HttpStatus.OK);
    }
}
