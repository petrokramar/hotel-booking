package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CountryRequest;
import com.hotelbooking.service.CountryService;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
@Import(SecurityConfig.class)
public class CountryControllerTest {

    private final String COUNTRIES_URL = "/countries";
    private final int  ID_ONE = 1;

    @MockBean
    private CountryService countryService;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllCountries() throws Exception {

        // given
        List<Country> countries = new ArrayList<>();
        countries.add(new Country(1, "Turkey"));
        countries.add(new Country(2, "Egypt"));
        countries.add(new Country(3, "Tunisia"));
        given(countryService.getAllCountries()).willReturn(countries);

        // when
        String result = mockMvc.perform(get(COUNTRIES_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(countries);
        verify(countryService).getAllCountries();
        verifyNoMoreInteractions(countryService);
    }

    @Test
    public void getCountry() throws Exception {

        // given
        Country country = new Country(1, "Turkey");
        given(countryService.getCountry(ID_ONE)).willReturn(country);

        // when
        String result = mockMvc.perform(get(COUNTRIES_URL.concat("/").concat("1"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(country);
        verify(countryService).getCountry(ID_ONE);
        verifyNoMoreInteractions(countryService);
    }

    @Test
    public void saveCountry() throws Exception {

        // given
        Country country = new Country(1, "Country name");
        CountryRequest request = new CountryRequest(1, "Country name");
        given(countryService.saveCountry(request)).willReturn(country);
        String requestJson = "{\"id\":\"1\",\"name\":\"Country name\"}";

        // when
        String result = mockMvc.perform(post(COUNTRIES_URL)
                .content(requestJson)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(country);
        verify(countryService).saveCountry(request);
        verifyNoMoreInteractions(countryService);
    }
}