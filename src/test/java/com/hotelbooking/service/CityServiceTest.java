package com.hotelbooking.service;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.entity.request.CountryRequest;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.impl.CityServiceImpl;
import com.hotelbooking.service.impl.CountryServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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
        Country country = new Country();
        country.setId(ID_ONE);
        country.setName("Turkey");
        List<City> expectedCities = new ArrayList<>();
        City cityOne = new City();
        cityOne.setId(ID_ONE);
        cityOne.setName("Kemer");
        cityOne.setCountry(country);
        expectedCities.add(cityOne);
        City cityTwo = new City();
        cityTwo.setId(ID_TWO);
        cityTwo.setName("Bodrum");
        cityTwo.setCountry(country);
        expectedCities.add(cityTwo);
        City cityThree = new City();
        cityThree.setId(ID_THREE);
        cityThree.setName("Marmaris");
        cityThree.setCountry(country);
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
        Country country = new Country();
        country.setId(ID_ONE);
        country.setName("Turkey");
        City expectedCity = new City();
        expectedCity.setId(ID_ONE);
        expectedCity.setName("Kemer");
        expectedCity.setCountry(country);
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
        CityRequest request = new CityRequest("1", "Kemer", "1");
        Country country = new Country();
        country.setId(ID_ONE);
        country.setName("Turkey");
        City expectedCity = new City();
        expectedCity.setId(ID_ONE);
        expectedCity.setName("Kemer");
        expectedCity.setCountry(country);
        given(countryRepository.findOne(ID_ONE)).willReturn(country);
        given(cityRepository.save(expectedCity)).willReturn(expectedCity);

        //when
        City actualCity = cityService.saveCity(request);

        //then
        assertEquals(expectedCity, actualCity);
        verify(countryRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(countryRepository);
        verify(cityRepository).save(expectedCity);
        verifyNoMoreInteractions(cityRepository);
    }
}