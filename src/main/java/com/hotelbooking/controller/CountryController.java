package com.hotelbooking.controller;

import com.hotelbooking.entity.Country;
import com.hotelbooking.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping(value = "/countries", produces = "application/json")
    public ResponseEntity<List<Country>> getBooking() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }
}