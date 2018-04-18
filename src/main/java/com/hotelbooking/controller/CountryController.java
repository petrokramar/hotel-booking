package com.hotelbooking.controller;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CountryRequest;
import com.hotelbooking.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/countries", produces = "application/json")
public class CountryController {

    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Country> saveCountry(@Valid @RequestBody CountryRequest request) {
        Country country = countryService.saveCountry(request);
        return ResponseEntity.ok(country);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Country> getСountry(@PathVariable String id) {
        Country country = countryService.getCountry(Integer.parseInt(id));
        return ResponseEntity.ok(country);
    }
}

