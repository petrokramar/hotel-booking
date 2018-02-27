package com.hotelbooking.repository;

import com.hotelbooking.entity.HotelService;
import com.hotelbooking.entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface HotelServiceRepository extends CrudRepository<HotelService, Long> {
}
