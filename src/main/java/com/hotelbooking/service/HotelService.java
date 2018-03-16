package com.hotelbooking.service;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.request.HotelRequest;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();

    Hotel getHotel(int id);

    Hotel saveHotel(HotelRequest hotel);

}
