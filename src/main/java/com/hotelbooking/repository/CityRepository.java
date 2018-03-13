package com.hotelbooking.repository;

import com.hotelbooking.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {

    List<City> findAllByOrderByName();
}
