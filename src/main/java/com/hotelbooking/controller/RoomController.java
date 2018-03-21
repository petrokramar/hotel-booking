package com.hotelbooking.controller;

import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.request.RoomRequest;
import com.hotelbooking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/rooms", produces = "application/json")
public class RoomController {

    private RoomService roomService;

    @GetMapping()
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Room> saveRoom(@Valid @RequestBody RoomRequest request) {
        Room room = roomService.saveRoom(request);
        return ResponseEntity.ok(room);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Room> getRoomCategory(@PathVariable String id) {
        Room room = roomService.getRoom(Integer.parseInt(id));
        return ResponseEntity.ok(room);
    }

}
