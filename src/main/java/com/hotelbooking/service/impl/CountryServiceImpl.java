package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CountryRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
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

    @Override
    public Country getCountry(int id) {
        Country country = countryRepository.findOne(id);
        if (country == null) {
            throw new DataNotFoundException(String.format("Country id= %s not found", id));
        }
        return country;
    }

    @Override
    public Country saveCountry(CountryRequest request) {
        int id = request.getId();
        String name = request.getName();
        Country country = new Country(id, name);
        return countryRepository.save(country);
    }
}
