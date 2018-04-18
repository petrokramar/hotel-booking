package com.hotelbooking.service;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.impl.CityServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class CityServiceTest {

    private final int ID_ONE = 1;
    private final int ID_TWO = 2;
    private final int ID_THREE = 3;
    private CountryRepository countryRepository;
    private CityRepository cityRepository;
    private CityService cityService;

    @Before
    public void setUp() {
        countryRepository = mock(CountryRepository.class);
        cityRepository = mock(CityRepository.class);
        cityService = new CityServiceImpl(cityRepository, countryRepository);
    }

    @Test
    public void getAllCities() {

        // given
        Country country = new Country(ID_ONE, "Country name");
        List<City> expectedCities = new ArrayList<>();
        City cityOne = new City(ID_ONE, "City one name", country);
        expectedCities.add(cityOne);
        City cityTwo = new City(ID_TWO, "City two name", country);
        expectedCities.add(cityTwo);
        City cityThree = new City(ID_THREE, "City three name", country);
        expectedCities.add(cityThree);
        given(cityRepository.findAllByOrderByName()).willReturn(expectedCities);

        //when
        List<City> actualCities = cityService.getAllCities();

        //then
        assertEquals(expectedCities, actualCities);
        verify(cityRepository).findAllByOrderByName();
        verifyNoMoreInteractions(cityRepository);
    }

    @Test
    public void getCity() {

        // given
        Country country = new Country(ID_ONE, "Country name");
        City expectedCity = new City(ID_ONE, "City name", country);
        given(cityRepository.findOne(ID_ONE)).willReturn(expectedCity);

        //when
        City actualCity = cityService.getCity(ID_ONE);

        //then
        assertEquals(expectedCity, actualCity);
        verify(cityRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(cityRepository);
    }

    @Test
    public void saveCity() {

        // given
        CityRequest request = new CityRequest(ID_ONE, "City name", ID_TWO);
        Country country = new Country(ID_TWO, "Country name");
        City expectedCity = new City(ID_ONE, "City name", country);
        given(countryRepository.findOne(ID_TWO)).willReturn(country);
        given(cityRepository.save(expectedCity)).willReturn(expectedCity);

        //when
        City actualCity = cityService.saveCity(request);

        //then
        assertEquals(expectedCity, actualCity);
        verify(countryRepository).findOne(ID_TWO);
        verifyNoMoreInteractions(countryRepository);
        verify(cityRepository).save(expectedCity);
        verifyNoMoreInteractions(cityRepository);
    }
}