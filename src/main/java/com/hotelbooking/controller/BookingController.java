package com.hotelbooking.controller;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.entity.request.BookingRequest;
import com.hotelbooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/booking", produces = "application/json")
public class BookingController {

    private BookingService bookingService;

    @GetMapping()
    public ResponseEntity<List<Booking>> getBooking() {
        List<Booking> booking = bookingService.getBooking();
        return ResponseEntity.ok(booking);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Booking> saveBooking(@Valid @RequestBody BookingRequest request) {
        Booking booking = bookingService.saveBooking(request);
        return ResponseEntity.ok(booking);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable int id) {
        Booking booking = bookingService.getBooking(id);
        return ResponseEntity.ok(booking);
    }

}