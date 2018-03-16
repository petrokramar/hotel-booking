package com.hotelbooking.service;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.request.BookingRequest;

import java.util.List;

public interface BookingService {

    List<Booking> getBooking();

    Booking getBooking(int id);

    Booking saveBooking(BookingRequest booking);
}
