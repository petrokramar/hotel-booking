package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.dto.RoomListDTO;
import com.hotelbooking.entity.request.RoomRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;
    private HotelRepository hotelRepository;
    private RoomCategoryRepository roomCategoryRepository;

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = (List<Room>) roomRepository.findAll();
        return rooms;
    }

    @Override
    public RoomListDTO getAllHotelRooms(int hotelId, int page, int size) {
        Page<Room> resultPage = roomRepository.findHotelRoomsPage(hotelId, new PageRequest(page, size));
        resultPage.getTotalElements();
        List<Room> rooms = resultPage.getContent();
        long totalElements = resultPage.getTotalElements();
        return new RoomListDTO(rooms, totalElements);
    }

    @Override
    public RoomListDTO getAllHotelFreeRooms(int hotelId, Date checkIn, Date checkOut, int page, int size) {
        Page<Room> resultPage = roomRepository.findHotelFreeRoomsPage(hotelId, checkIn, checkOut,
                new PageRequest(page, size));
        resultPage.getTotalElements();
        List<Room> rooms = resultPage.getContent();
        long totalElements = resultPage.getTotalElements();
        return new RoomListDTO(rooms, totalElements);
    }

    @Override
    public Room getRoom(int id) {
        Room room = roomRepository.findOne(id);
        if (room == null) {
            throw new DataNotFoundException(String.format("Room id= %s not found", id));
        }
        return room;
    }

    @Override
    public Room saveRoom(RoomRequest request) {
        Hotel hotel = hotelRepository.findOne(request.getHotelId());
        RoomCategory roomCategory = roomCategoryRepository.findOne(request.getRoomCategoryId());
        Room room = new Room(request.getId(), request.getNumber(), hotel, roomCategory, request.getPrice(),
                request.getPersons());
        return roomRepository.save(room);
    }
}
