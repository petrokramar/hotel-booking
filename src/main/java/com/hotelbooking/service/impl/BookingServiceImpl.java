package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.User;
import com.hotelbooking.entity.request.BookingRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;

    @Override
    public List<Booking> getAllBooking() {
        List<Booking> booking = (List<Booking>) bookingRepository.findAll();
        return booking;
    }

    @Override
    public Booking getBooking(int id) {
        Booking booking = bookingRepository.findOne(id);
        return Optional.ofNullable(booking).orElseThrow(() ->
                new DataNotFoundException(String.format("Booking id= %s not found", id)));
    }

    @Override
    public Booking saveBooking(BookingRequest request) {
        User user = userRepository.findOne(request.getUsername());
        Room room = roomRepository.findOne(request.getRoomId());
        Booking booking = new Booking(request.getId(), room, user, request.getTotalSum(), request.getPersons(),
                request.getCheckIn(), request.getCheckOut());
        return bookingRepository.save(booking);
    }
}
