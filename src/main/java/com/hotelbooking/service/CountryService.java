package com.hotelbooking.service;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CountryRequest;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountry(int id);

    Country saveCountry(CountryRequest country);
}
