package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return (List<Hotel>) hotelRepository.findAll();
    }
}
