package com.hotelbooking.controller;

import com.hotelbooking.entity.Room;
import com.hotelbooking.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class RoomController {

    @Inject
    RoomService roomService;

    @GetMapping(value = "/rooms", produces = "application/json")
    public List<Room> getRooms() {
        List<Room> rooms = roomService.getRooms();
        return rooms;
    }
}
