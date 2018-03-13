package com.hotelbooking.repository;

import com.hotelbooking.entity.Room;
import com.hotelbooking.entity.RoomCategory;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
