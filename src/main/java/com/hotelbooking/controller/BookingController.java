package com.hotelbooking.controller;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.entity.Room;
import com.hotelbooking.service.BookingService;
import com.hotelbooking.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class BookingController {

    @Inject
    BookingService bookingService;

    @GetMapping(value = "/booking", produces = "application/json")
    public List<Booking> getBooking() {
        List<Booking> booking = bookingService.getBooking();
        return booking;
    }
}
