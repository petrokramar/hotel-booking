package com.hotelbooking.service;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.request.CityRequest;

import java.util.List;

public interface CityService {

    List<City> getAllCities();

    City getCity(int id);

    City saveCity(CityRequest city);
}
