package com.hotelbooking.repository;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RoomCategoryRepository extends CrudRepository<RoomCategory, Integer> {
}
