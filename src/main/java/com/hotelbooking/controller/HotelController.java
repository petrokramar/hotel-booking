package com.hotelbooking.controller;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.request.HotelRequest;
import com.hotelbooking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/hotels", produces = "application/json")
public class HotelController {

    private HotelService hotelService;

    @GetMapping()
    public ResponseEntity<List<Hotel>> getHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Hotel> saveHotel(@Valid @RequestBody HotelRequest request) {
        Hotel hotel = hotelService.saveHotel(request);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        Hotel hotel = hotelService.getHotel(Integer.parseInt(id));
        return ResponseEntity.ok(hotel);
    }
}