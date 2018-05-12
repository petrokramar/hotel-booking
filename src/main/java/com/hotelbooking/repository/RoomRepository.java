package com.hotelbooking.repository;

import com.hotelbooking.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    @Query("Select r from Room r where r.hotel.id = ?1 order by r.number")
    Page<Room> findHotelRoomsPage(int hotelId, Pageable pageable);
}
