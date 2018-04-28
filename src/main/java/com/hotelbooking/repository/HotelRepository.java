package com.hotelbooking.repository;

import com.hotelbooking.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    @Query("Select h from Hotel h where lower(h.name) like lower(concat('%', :filter,'%'))")
    Page<Hotel> findHotelPage(@Param(value = "filter") String filter, Pageable pageable);

}
