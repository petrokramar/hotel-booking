package com.hotelbooking.controller;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.service.RoomCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoomCategoryController {

    private RoomCategoryService roomCategoryService;

    @GetMapping(value = "/roomCategories", produces = "application/json")
    public ResponseEntity<List<RoomCategory>> getAllRoomCategories() {
        List<RoomCategory> roomCategories = roomCategoryService.getAllRoomCategories();
        return ResponseEntity.ok(roomCategories);
    }
}