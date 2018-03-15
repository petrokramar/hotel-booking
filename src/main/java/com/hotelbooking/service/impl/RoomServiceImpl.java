package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Room;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = (List<Room>) roomRepository.findAll();
        return rooms;
    }
}
