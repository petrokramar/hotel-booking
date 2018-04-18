package com.hotelbooking.service;

import com.hotelbooking.entity.*;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.repository.HotelOptionRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.impl.BookingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class BookingServiceTest {

    private final int ID_ONE = 1;
    private final int ID_TWO = 2;
    private final int ID_THREE = 3;
    private final int ROOM_NUMBER_ONE = 1;
    private final int ROOM_NUMBER_TWO = 2;
    private final int ROOM_NUMBER_THREE = 3;
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private HotelOptionRepository hotelOptionRepository;
    private BookingService bookingService;

    @Before
    public void setUp() {
        bookingRepository = mock(BookingRepository.class);
        userRepository = mock(UserRepository.class);
        roomRepository = mock(RoomRepository.class);
        hotelOptionRepository = mock(HotelOptionRepository.class);
        bookingService = new BookingServiceImpl(bookingRepository, userRepository, roomRepository,
                hotelOptionRepository);
    }

    @Test
    public void getBooking() {

        // given
        Country country = new Country(ID_ONE, "Country name");
        City city = new City();
        city.setId(ID_ONE);
        city.setName("Kemer");
        city.setCountry(country);
        Hotel hotel = new Hotel();
        hotel.setId(ID_ONE);
        hotel.setName("Hotel name 1");
        hotel.setCity(city);
        hotel.setCategory(HotelCategory.FIVE_STARS);
        RoomCategory roomCategory = new RoomCategory();
        roomCategory.setId(ID_ONE);
        roomCategory.setName("Room category 1");
        roomCategory.setDescription("Room category 1 description");

        Set<Authority> rolesUserOne = new HashSet<>();
        Authority roleOne = new Authority();
        roleOne.setId(ID_ONE);
        roleOne.setAuthority("ROLE_ADMIN");
        roleOne.setUsername("user1");
        rolesUserOne.add(roleOne);
        User userOne = new User();
        userOne.setFirstName("First name user 1");
        userOne.setLastName("Last name user 1");
        userOne.setUsername("user1");
        userOne.setPassword("password1");
        userOne.setRoles(rolesUserOne);
        userOne.setEnabled(true);

        Room roomOne = new Room();
        roomOne.setId(ID_ONE);
        roomOne.setNumber(ROOM_NUMBER_ONE);
        roomOne.setHotel(hotel);
        roomOne.setRoomCategory(roomCategory);

        List<Booking> expectedBooking = new ArrayList<>();

        Booking bookingOne = new Booking();
        bookingOne.setId(ID_ONE);
        bookingOne.setUser(userOne);
        bookingOne.setRoom(roomOne);
        bookingOne.setDateBegin(new Date());
        bookingOne.setDateEnd(new Date());
//        bookingOne.setHotelServices();
        expectedBooking.add(bookingOne);
        given(bookingRepository.findAll()).willReturn(expectedBooking);

        //when
        List<Booking> actualBooking = bookingService.getBooking();

        //then
        assertEquals(expectedBooking, actualBooking);


        verify(bookingRepository).findAll();
        verifyNoMoreInteractions(bookingRepository);

    }

    @Test
    public void getBooking1() {
    }

    @Test
    public void saveBooking() {
    }
}