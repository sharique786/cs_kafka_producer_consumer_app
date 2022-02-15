package com.cs.kafka.controller;

import com.cs.kafka.model.Country;
import com.cs.kafka.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Country>> saveAll(@Valid @RequestBody List<Country> countries) {
        try {
            return new ResponseEntity<>(countryService.saveAll(countries), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Country country) {
        try {
            countryService.save(country);
            return new ResponseEntity<>("Saved", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-by-country/{countryName}")
    public ResponseEntity<String> deleteByCountryName(@PathVariable("countryName") String countryName) {
        try {
            countryService.deleteByCountryName(countryName);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<Country> getCountryByCity(@PathVariable("cityName") String cityName) {
        try {
            return new ResponseEntity<>(countryService.getCountryByCity(cityName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
