package com.hotelbooking.repository;

import com.hotelbooking.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}
