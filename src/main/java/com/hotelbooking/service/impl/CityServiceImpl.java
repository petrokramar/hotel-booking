package com.hotelbooking.service.impl;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.dto.CityListDTO;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    private CityRepository repository;
    private CountryRepository countryRepository;

    @Override
    public List<City> getAllCities() {
        return repository.findAllByOrderByName();
    }

    @Override
    public CityListDTO getCitiesPage(String filter, String sortOrder, int page, int size) {
        Sort.Direction sortDirection = Sort.Direction.ASC;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            sortDirection = Sort.Direction.DESC;
        }
        Page< City > resultPage = repository.findCityPage(filter,
                new PageRequest(page, size, sortDirection, "name"));
        resultPage.getTotalElements();
        List<City> cities = resultPage.getContent();
        long totalElements = resultPage.getTotalElements();
        return new CityListDTO(cities, totalElements);
    }

    @Override
    public City getCity(int id) {
        City city = repository.findOne(id);
        return Optional.ofNullable(city).orElseThrow(() ->
                new DataNotFoundException(String.format("City id= %s not found", id)));
    }

    @Override
    public City saveCity(CityRequest request) {

        Country country = countryRepository.findOne(request.getCountryId());
        City city = new City(request.getId(), request.getName(), country);
        return repository.save(city);
    }
}
