package com.hotelbooking.repository;

import com.hotelbooking.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository  extends CrudRepository<Country, Integer> {

    List<Country> findAllByOrderByName();

    Page<Country> findAllByOrderByName(Pageable pageable);
}
