package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Room;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.service.RoomService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Inject
    RoomRepository roomRepository;

    @Override
    public List<Room> getRooms() {
        List<Room> rooms = (List<Room>) roomRepository.findAll();
        return rooms;
    }
}
