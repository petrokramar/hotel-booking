package com.hotelbooking.service.impl;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAllByOrderByName();
    }

    @Override
    public City getCity(int id) {
        City city = cityRepository.findOne(id);
        if (city == null) {
            throw new DataNotFoundException(String.format("City id= %s not found", id));
        }
        return city;
    }

    @Override
    public City saveCity(CityRequest request) {

        Country country = countryRepository.findOne(request.getCountryId());
        City city = new City(request.getId(), request.getName(), country);
        return cityRepository.save(city);
    }
}
