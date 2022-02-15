package com.cs.kafka.service;

import com.cs.kafka.model.Country;
import com.cs.kafka.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> saveAll(List<Country> countryList) {
        List<Country> savedList = countryRepository.saveAll(countryList);
        log.info("No of saved Country objs: [{}]", savedList.size());
        return savedList;
    }

    public void save(Country country) {
        countryRepository.save(country);
        log.info("Country data saved: [{}]", country);
    }

    public void deleteByCountryName(String countryName) {
        countryRepository.deleteByCountryName(countryName);
    }

    public Country getCountryByCity(String cityName) {
        return countryRepository.getByCityName(cityName);
    }
}
