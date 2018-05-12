package com.hotelbooking.service;

import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.dto.RoomListDTO;
import com.hotelbooking.entity.request.RoomRequest;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();

    RoomListDTO getAllHotelRooms(int hotelId, int page, int size);

    Room getRoom(int id);

    Room saveRoom(RoomRequest country);
}
