package com.hotelbooking.service.impl;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.request.HotelRequest;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private CityRepository cityRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(int id) {
        return hotelRepository.findOne(id);
    }

    @Override
    public Hotel saveHotel(HotelRequest request) {
        Hotel hotel = new Hotel();
        hotel.setId(request.getId());
        hotel.setName(request.getName());
        hotel.setCity(cityRepository.findOne(Integer.parseInt(request.getCityId())));
        return hotelRepository.save(hotel);
    }
}
