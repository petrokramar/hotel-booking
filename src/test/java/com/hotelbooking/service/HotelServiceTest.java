package com.hotelbooking.service;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.HotelCategory;
import com.hotelbooking.entity.request.HotelRequest;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.service.impl.HotelServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class HotelServiceTest {

    private final int ID_ONE = 1;
    private final int ID_TWO = 2;
    private final int ID_THREE = 3;
    private HotelRepository hotelRepository;
    private CityRepository cityRepository;
    private HotelService hotelService;

    @Before
    public void setUp() {
        cityRepository = mock(CityRepository.class);
        hotelRepository = mock(HotelRepository.class);
        hotelService = new HotelServiceImpl(hotelRepository, cityRepository);
    }

    @Test
    public void getAllHotels() {

        // given
        Country country = new Country(ID_ONE, "Country name");
        City city = new City();
        city.setId(ID_ONE);
        city.setName("Kemer");
        city.setCountry(country);

        List<Hotel> expectedHotels = new ArrayList<>();
        Hotel hotelOne = new Hotel();
        hotelOne.setId(ID_ONE);
        hotelOne.setName("Hotel name 1");
        hotelOne.setCity(city);
        hotelOne.setCategory(HotelCategory.THREE_STARS);
        expectedHotels.add(hotelOne);
        Hotel hotelTwo = new Hotel();
        hotelTwo.setId(ID_TWO);
        hotelTwo.setName("Hotel name 2");
        hotelTwo.setCity(city);
        hotelOne.setCategory(HotelCategory.FOUR_STARS);
        expectedHotels.add(hotelTwo);
        Hotel hotelThree = new Hotel();
        hotelThree.setId(ID_THREE);
        hotelThree.setName("Hotel name 3");
        hotelThree.setCity(city);
        hotelOne.setCategory(HotelCategory.FIVE_STARS);
        expectedHotels.add(hotelThree);
        given(hotelRepository.findAll()).willReturn(expectedHotels);

        //when
        List<Hotel> actualHotels = hotelService.getAllHotels();

        //then
        assertEquals(expectedHotels, actualHotels);
        verify(hotelRepository).findAll();
        verifyNoMoreInteractions(hotelRepository);
    }

    @Test
    public void getHotel() {

        // given
        Country country = new Country(ID_ONE, "Country name");
        City city = new City();
        city.setId(ID_ONE);
        city.setName("Kemer");
        city.setCountry(country);
        Hotel expectedHotel = new Hotel();
        expectedHotel.setId(ID_ONE);
        expectedHotel.setName("Hotel name 1");
        expectedHotel.setCity(city);
        expectedHotel.setCategory(HotelCategory.FOUR_STARS);
        given(hotelRepository.findOne(ID_ONE)).willReturn(expectedHotel);

        //when
        Hotel actualHotel = hotelService.getHotel(ID_ONE);

        //then
        assertEquals(expectedHotel, actualHotel);
        verify(hotelRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(hotelRepository);
    }

    @Test
    public void saveHotel() {

        // given
        HotelRequest request = new HotelRequest(ID_ONE, "Hotel name 1", ID_ONE,"FIVE_STARS");
        Country country = new Country(ID_ONE, "Country name");
        City city = new City();
        city.setId(ID_ONE);
        city.setName("Kemer");
        city.setCountry(country);
        Hotel expectedHotel = new Hotel();
        expectedHotel.setId(ID_ONE);
        expectedHotel.setName("Hotel name 1");
        expectedHotel.setCity(city);
        expectedHotel.setCategory(HotelCategory.FIVE_STARS);
        given(cityRepository.findOne(ID_ONE)).willReturn(city);
        given(hotelRepository.save(expectedHotel)).willReturn(expectedHotel);

        //when
        Hotel actualHotel = hotelService.saveHotel(request);

        //then
        assertEquals(expectedHotel, actualHotel);
        verify(cityRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(cityRepository);
        verify(hotelRepository).save(expectedHotel);
        verifyNoMoreInteractions(hotelRepository);
    }
}