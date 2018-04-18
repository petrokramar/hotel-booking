package com.hotelbooking.service;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CountryRequest;
import com.hotelbooking.repository.CountryRepository;
import com.hotelbooking.service.impl.CountryServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class CountryServiceTest {

    private final int ID_ONE = 1;
    private final int ID_TWO = 2;
    private final int ID_THREE = 3;
    private CountryRepository countryRepository;
    private CountryService countryService;

    @Before
    public void setUp() {
        countryRepository = mock(CountryRepository.class);
        countryService = new CountryServiceImpl(countryRepository);
    }

    @Test
    public void getAllCountries() {

        // given
        List<Country> expectedCountries = new ArrayList<>();
        Country countryOne = new Country(ID_ONE, "Country one name");
        expectedCountries.add(countryOne);
        Country countryTwo = new Country(ID_TWO, "Country two name");
        expectedCountries.add(countryTwo);
        Country countryThree = new Country(ID_ONE, "Country three name");
        expectedCountries.add(countryThree);
        given(countryRepository.findAllByOrderByName()).willReturn(expectedCountries);

        //when
        List<Country> actualCountries = countryService.getAllCountries();

        //then
        assertEquals(expectedCountries, actualCountries);
        verify(countryRepository).findAllByOrderByName();
        verifyNoMoreInteractions(countryRepository);
    }

    @Test
    public void getCountry() {

        // given
        Country expectedCountry = new Country(ID_ONE, "Country name");
        given(countryRepository.findOne(ID_ONE)).willReturn(expectedCountry);

        //when
        Country actualCountry = countryService.getCountry(ID_ONE);

        //then
        assertEquals(expectedCountry, actualCountry);
        verify(countryRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(countryRepository);
    }

    @Test
    public void saveCountry() {

        // given
        CountryRequest request = new CountryRequest(ID_ONE, "Country name");
        Country expectedCountry = new Country(request.getId(), request.getName());
        given(countryRepository.save(expectedCountry)).willReturn(expectedCountry);

        //when
        Country actualCountry = countryService.saveCountry(request);

        //then
        assertEquals(expectedCountry, actualCountry);
        verify(countryRepository).save(expectedCountry);
        verifyNoMoreInteractions(countryRepository);
    }
}