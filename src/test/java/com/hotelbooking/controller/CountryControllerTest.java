package com.hotelbooking.controller;

import com.hotelbooking.entity.Country;
import com.hotelbooking.service.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryControllerTest.class)
public class CountryControllerTest {

    private final String COUNTRIES_URL = "/countries";

    @MockBean
    private CountryService countryService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRandomMultiplicationTest() throws Exception {

//        List<Country> countries = new ArrayList<>();
//        countries.add(new Country(1, "Turkey"));
//        countries.add(new Country(2, "Egypt"));
//        countries.add(new Country(3, "Tunisia"));
//
//        // given
//        given(countryService.getAllCountries()).willReturn(countries);
//
//        // when
//        String result = mockMvc.perform(get(COUNTRIES_URL)
//                .contentType(APPLICATION_JSON_UTF8))
//                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//
//        // then
//        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(countries);
//        verify(countryService).getAllCountries();
//        verifyNoMoreInteractions(countryService);
    }
}