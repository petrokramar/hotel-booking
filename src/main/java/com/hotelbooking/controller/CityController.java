package com.hotelbooking.controller;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cities", produces = "application/json")
public class CityController {

    private CityService cityService;

    @GetMapping()
    public ResponseEntity<List<City>> getAllCities() {
        List<City> countries = cityService.getAllCities();
        return ResponseEntity.ok(countries);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<City> saveCity(@Valid @RequestBody CityRequest request) {
        City city = cityService.saveCity(request);
        return ResponseEntity.ok(city);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id) {
        City city = cityService.getCity(Integer.parseInt(id));
        return ResponseEntity.ok(city);
    }
}