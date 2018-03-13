package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getBooking() {
        List<Booking> booking = (List<Booking>) bookingRepository.findAll();
        return booking;
    }
}
