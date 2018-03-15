package com.hotelbooking.service.impl;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.request.CityRequest;
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
        return cityRepository.findOne(id);
    }

    @Override
    public City saveCity(CityRequest request) {
        City city = new City();
        city.setId(Integer.parseInt(request.getId()));
        city.setName(request.getName());
        city.setCountry(countryRepository.findOne(Integer.parseInt(request.getCountryId())));
        return cityRepository.save(city);
    }
}
