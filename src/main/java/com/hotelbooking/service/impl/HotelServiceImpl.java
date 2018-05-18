package com.hotelbooking.service.impl;

import com.hotelbooking.entity.City;
import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.HotelCategory;
import com.hotelbooking.entity.dto.HotelListDTO;
import com.hotelbooking.entity.request.HotelRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.CityRepository;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public HotelListDTO getHotelsPage(String filter, String sortOrder, int page, int size) {
        Sort.Direction sortDirection = Sort.Direction.ASC;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            sortDirection = Sort.Direction.DESC;
        }
        Page< Hotel > resultPage = hotelRepository.findHotelPage(filter,
                new PageRequest(page, size, sortDirection, "name"));
        resultPage.getTotalElements();
        List<Hotel> hotels = resultPage.getContent();
        long totalElements = resultPage.getTotalElements();
        return new HotelListDTO(hotels, totalElements);
    }

    @Override
    public HotelListDTO getHotelsWithFreeRoomsPage(int cityId, Date checkIn, Date checkOut, int page, int size) {
        Page< Hotel > resultPage = hotelRepository.findHotelsWithFreeRoomsPage(cityId, checkIn, checkOut,
                new PageRequest(page, size));
        resultPage.getTotalElements();
        List<Hotel> hotels = resultPage.getContent();
        long totalElements = resultPage.getTotalElements();
        return new HotelListDTO(hotels, totalElements);
    }

    @Override
    public Hotel getHotel(int id) {
        Hotel hotel = hotelRepository.findOne(id);
        if (hotel == null) {
            throw new DataNotFoundException(String.format("Hotel id= %s not found", id));
        }
        return hotel;
    }

    @Override
    public Hotel saveHotel(HotelRequest request) {

        City city = cityRepository.findOne(request.getCityId());
        HotelCategory  hotelCategory = HotelCategory.valueOf(request.getCategory());
        Hotel hotel = new Hotel(request.getId(), request.getName(), city , hotelCategory);
        return hotelRepository.save(hotel);
    }
}
