package com.hotelbooking.service;

import com.hotelbooking.entity.*;
import com.hotelbooking.entity.request.RoomRequest;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.service.impl.RoomServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class RoomServiceTest {

    private final int ID_ONE = 1;
    private final int ID_TWO = 2;
    private final int ID_THREE = 3;
    private final int ROOM_NUMBER_ONE = 1;
    private final int ROOM_NUMBER_TWO = 2;
    private final int ROOM_NUMBER_THREE = 3;
    private final int ROOM_PRICE = 100;
    private final int ROOM_NUMBER_OF_PERSONS = 2;
    private HotelRepository hotelRepository;
    private RoomCategoryRepository roomCategoryRepository;
    private RoomRepository roomRepository;
    private RoomService roomService;

    @Before
    public void setUp() {
        roomRepository = mock(RoomRepository.class);
        hotelRepository = mock(HotelRepository.class);
        roomCategoryRepository = mock(RoomCategoryRepository.class);
        roomService = new RoomServiceImpl(roomRepository, hotelRepository, roomCategoryRepository);
    }

    @Test
    public void getAllRooms() {

        // given
        Country country = new Country();
        country.setId(ID_ONE);
        country.setName("Turkey");
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

        List<Room> expectedRooms = new ArrayList<>();
        Room roomOne = new Room();
        roomOne.setId(ID_ONE);
        roomOne.setNumber(ROOM_NUMBER_ONE);
        roomOne.setHotel(hotel);
        roomOne.setRoomCategory(roomCategory);
        roomOne.setPrice(ROOM_PRICE);
        roomOne.setPersons(ROOM_NUMBER_OF_PERSONS);
        expectedRooms.add(roomOne);
        Room roomTwo = new Room();
        roomTwo.setId(ID_TWO);
        roomTwo.setNumber(ROOM_NUMBER_TWO);
        roomTwo.setHotel(hotel);
        roomTwo.setRoomCategory(roomCategory);
        roomTwo.setPrice(ROOM_PRICE);
        roomTwo.setPersons(ROOM_NUMBER_OF_PERSONS);
        expectedRooms.add(roomTwo);
        Room roomThree = new Room();
        roomThree.setId(ID_THREE);
        roomThree.setNumber(ROOM_NUMBER_THREE);
        roomThree.setHotel(hotel);
        roomThree.setRoomCategory(roomCategory);
        roomThree.setPrice(ROOM_PRICE);
        roomThree.setPersons(ROOM_NUMBER_OF_PERSONS);
        expectedRooms.add(roomThree);
        given(roomRepository.findAll()).willReturn(expectedRooms);

        //when
        List<Room> actualRooms = roomService.getAllRooms();

        //then
        assertEquals(expectedRooms, actualRooms);
        verify(roomRepository).findAll();
        verifyNoMoreInteractions(roomRepository);
    }

    @Test
    public void getRoom() {

        // given
        Country country = new Country();
        country.setId(ID_ONE);
        country.setName("Turkey");
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
        Room expectedRoom = new Room();
        expectedRoom.setId(ID_ONE);
        expectedRoom.setNumber(ROOM_NUMBER_ONE);
        expectedRoom.setHotel(hotel);
        expectedRoom.setRoomCategory(roomCategory);
        expectedRoom.setPrice(ROOM_PRICE);
        expectedRoom.setPersons(ROOM_NUMBER_OF_PERSONS);
        given(roomRepository.findOne(ID_ONE)).willReturn(expectedRoom);

        //when
        Room actualRoom = roomService.getRoom(ID_ONE);

        //then
        assertEquals(expectedRoom, actualRoom);
        verify(roomRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(roomRepository);
    }

    @Test
    public void saveRoom() {

        // given
        RoomRequest request = new RoomRequest(ID_ONE, ID_ONE, ID_ONE, ID_ONE, ROOM_PRICE, ROOM_NUMBER_OF_PERSONS);
        Country country = new Country();
        country.setId(ID_ONE);
        country.setName("Turkey");
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
        Room expectedRoom = new Room();
        expectedRoom.setId(ID_ONE);
        expectedRoom.setNumber(ROOM_NUMBER_ONE);
        expectedRoom.setHotel(hotel);
        expectedRoom.setRoomCategory(roomCategory);
        expectedRoom.setPrice(ROOM_PRICE);
        expectedRoom.setPersons(ROOM_NUMBER_OF_PERSONS);
        given(hotelRepository.findOne(ID_ONE)).willReturn(hotel);
        given(roomCategoryRepository.findOne(ID_ONE)).willReturn(roomCategory);
        given(roomRepository.save(expectedRoom)).willReturn(expectedRoom);

        //when
        Room actualRoom = roomService.saveRoom(request);

        //then
        assertEquals(expectedRoom, actualRoom);
        verify(hotelRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(hotelRepository);
        verify(roomCategoryRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(roomCategoryRepository);
        verify(roomRepository).save(expectedRoom);
        verifyNoMoreInteractions(roomRepository);
    }
}