package com.hotelbooking.controller;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.dto.CityListDTO;
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

    @GetMapping(params = {"filter", "sortOrder", "page", "size"})
    public ResponseEntity<CityListDTO> getCitiesPage(@RequestParam( "filter" ) String filter,
                                                     @RequestParam( "sortOrder" ) String sortOrder,
                                                     @RequestParam( "page" ) int page,
                                                     @RequestParam( "size" ) int size) {
        CityListDTO cities = cityService.getCitiesPage(filter, sortOrder, page, size);
        return ResponseEntity.ok(cities);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<City> saveCity(@Valid @RequestBody CityRequest request) {
        City city = cityService.saveCity(request);
        return ResponseEntity.ok(city);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getCity(@PathVariable int id) {
        City city = cityService.getCity(id);
        return ResponseEntity.ok(city);
    }
}