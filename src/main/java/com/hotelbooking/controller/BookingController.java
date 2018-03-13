package com.hotelbooking.controller;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @GetMapping(value = "/booking", produces = "application/json")
    public ResponseEntity<List<Booking>> getBooking() {
        List<Booking> booking = bookingService.getBooking();
        return ResponseEntity.ok(booking);
    }
}