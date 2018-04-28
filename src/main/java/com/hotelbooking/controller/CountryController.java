package com.hotelbooking.controller;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.dto.CountryListDTO;
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

    @GetMapping(params = {"filter", "sortOrder", "page", "size"})
    public ResponseEntity<CountryListDTO> getCountriesPage(@RequestParam( "filter" ) String filter,
                                                           @RequestParam( "sortOrder" ) String sortOrder,
                                                           @RequestParam( "page" ) int page,
                                                           @RequestParam( "size" ) int size) {
        CountryListDTO countries = countryService.getCountriesPage(filter, sortOrder, page, size);
        return ResponseEntity.ok(countries);
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Long> countAllCountries() {
        Long total = countryService.countAllCountries();
        return ResponseEntity.ok(total);
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

