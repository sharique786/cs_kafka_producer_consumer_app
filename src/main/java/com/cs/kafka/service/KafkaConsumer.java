package com.cs.kafka.service;

import com.cs.kafka.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private static final String TOPIC = "input_topic";

    private Country country = null;

    @KafkaListener(topics = TOPIC, groupId = "cs_group")
    public void consume(Country country) {
        this.country = country;
        log.info("City data Received: [{}]", this.country);
    }

    public Country getCountry() {
        return this.country;
    }
}
