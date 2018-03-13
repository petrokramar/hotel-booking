package com.hotelbooking.controller;

import com.hotelbooking.entity.City;
import com.hotelbooking.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @GetMapping(value = "/cities", produces = "application/json")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> countries = cityService.getAllCities();
        return ResponseEntity.ok(countries);
    }
}