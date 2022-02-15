package com.cs.kafka.service;

import com.cs.kafka.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    private static final String TOPIC = "input_topic";

    private final KafkaTemplate<String, Country> kafkaTemplate;
    private final CountryService countryService;

    public KafkaProducer(KafkaTemplate<String, Country> kafkaTemplate, CountryService countryService) {
        this.kafkaTemplate = kafkaTemplate;
        this.countryService = countryService;
    }

    public void publish(String cityName) {
        Country country = countryService.getCountryByCity(cityName);
        log.info("Publishing Country data: [{}]", country);
        kafkaTemplate.send(TOPIC, country);
    }
}
