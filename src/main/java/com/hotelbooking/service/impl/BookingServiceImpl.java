package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.service.BookingService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Inject
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getBooking() {
        List<Booking> booking = (List<Booking>) bookingRepository.findAll();
        return booking;
    }
}
