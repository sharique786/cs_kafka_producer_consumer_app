package com.cs.kafka.repository;

import com.cs.kafka.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from Country_Data c where c.country=:country")
    void deleteByCountryName(@Param("country") String countryName);

    Country getByCityName(String cityName);
}
