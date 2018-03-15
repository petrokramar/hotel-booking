package com.hotelbooking.controller;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class HotelController {

    private HotelService hotelService;

    @GetMapping(value = "/hotels", produces = "application/json")
    public ResponseEntity<List<Hotel>> getHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }
}
