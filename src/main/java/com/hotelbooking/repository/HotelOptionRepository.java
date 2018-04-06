package com.hotelbooking.repository;

import com.hotelbooking.entity.HotelService;
import org.springframework.data.repository.CrudRepository;

public interface HotelOptionRepository extends CrudRepository<HotelService, Integer> {
}
