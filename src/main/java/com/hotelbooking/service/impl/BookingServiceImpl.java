package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.entity.HotelService;
import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.User;
import com.hotelbooking.entity.request.BookingRequest;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.repository.HotelOptionRepository;
import com.hotelbooking.repository.RoomRepository;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private HotelOptionRepository hotelOptionRepository;

    @Override
    public List<Booking> getBooking() {
        List<Booking> booking = (List<Booking>) bookingRepository.findAll();
        return booking;
    }

    @Override
    public Booking getBooking(int id) {
        return bookingRepository.findOne(id);
    }

    @Override
    public Booking saveBooking(BookingRequest request) {
        Booking booking = new Booking();
        booking.setId(request.getId());
        User user = userRepository.findOne(request.getUsername());
        booking.setUser(user);
        Room room = roomRepository.findOne(request.getRoomId());
        booking.setRoom(room);
        booking.setDateBegin(request.getDateBegin());
        booking.setDateEnd(request.getDateEnd());
//        List <Integer> hotelServicesIds =
//                request.getHotelServiceIds().stream().map(Integer::parseInt).collect(Collectors.toList());
        List<HotelService> hotelServices =
                (List<HotelService>) hotelOptionRepository.findAll(request.getHotelServiceIds());
        booking.setHotelServices(hotelServices);
        return bookingRepository.save(booking);
    }
}
