package com.hotelbooking.service.impl;

import com.hotelbooking.entity.City;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAllByOrderByName();
    }
}
