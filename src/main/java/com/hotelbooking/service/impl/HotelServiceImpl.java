package com.hotelbooking.service.impl;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.HotelCategory;
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

        City city = cityRepository.findOne(request.getCityId());
        HotelCategory  hotelCategory = HotelCategory.valueOf(request.getCategory());
        Hotel hotel = new Hotel(request.getId(), request.getName(), city , hotelCategory);
        return hotelRepository.save(hotel);
    }
}
