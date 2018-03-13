package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Country;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{

    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAllByOrderByName();
    }
}
