package com.hotelbooking.controller;

import com.hotelbooking.config.SecurityConfig;
import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.request.CityRequest;
import com.hotelbooking.service.CityService;
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
@WebMvcTest(CityController.class)
@Import(SecurityConfig.class)
public class CityControllerTest{

    private final String CITIES_URL = "/cities";
    private final int  ID_ONE = 1;
    private final int  ID_TWO = 2;
    private final int  ID_THREE = 3;

    @MockBean
    private CityService cityService;

    @Inject
    private MockMvc mockMvc;

    @Test
    public void getAllCities() throws Exception {

        // given
        Country country = new Country(ID_ONE, "Country name");
        List<City> cities = new ArrayList<>();
        cities.add(new City(ID_ONE, "City one name", country));
        cities.add(new City(ID_TWO, "City two name", country));
        cities.add(new City(ID_THREE, "City three name", country));
        given(cityService.getAllCities()).willReturn(cities);

        // when
        String result = mockMvc.perform(get(CITIES_URL)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(cities);
        verify(cityService).getAllCities();
        verifyNoMoreInteractions(cityService);
    }

    @Test
    public void saveCity() throws Exception {

        // given
        Country country = new Country(ID_ONE, "Country name");
        City city = new City(ID_TWO, "City name", country);
        CityRequest request = new CityRequest(ID_TWO, "City name", ID_ONE);
        given(cityService.saveCity(request)).willReturn(city);
        String requestJson = "{\"id\":\"2\",\"name\":\"City name\",\"countryId\":\"1\"}";

        // when
        String result = mockMvc.perform(post(CITIES_URL)
                .content(requestJson)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(city);
        verify(cityService).saveCity(request);
        verifyNoMoreInteractions(cityService);
    }

    @Test
    public void getCity() throws Exception {

        // given
        Country country = new Country(ID_ONE, "Country name");
        City city = new City(ID_ONE, "City name", country);
        given(cityService.getCity(ID_ONE)).willReturn(city);

        // when
        String result = mockMvc.perform(get(CITIES_URL.concat("/").concat("1"))
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThatJson(result).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(city);
        verify(cityService).getCity(ID_ONE);
        verifyNoMoreInteractions(cityService);
    }
}
