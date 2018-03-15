package com.hotelbooking.controller;

import com.hotelbooking.entity.Room;
import com.hotelbooking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoomController {

    private RoomService roomService;

    @GetMapping(value = "/rooms", produces = "application/json")
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
}
