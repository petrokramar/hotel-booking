package com.hotelbooking.repository;

import com.hotelbooking.entity.AdditionalService;
import org.springframework.data.repository.CrudRepository;

public interface HotelServiceRepository extends CrudRepository<AdditionalService, Integer> {
}
