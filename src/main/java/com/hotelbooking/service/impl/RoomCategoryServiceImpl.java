package com.hotelbooking.service.impl;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.service.RoomCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RoomCategoryServiceImpl implements RoomCategoryService {

    private RoomCategoryRepository roomCategoryRepository;

    @Override
    public List<RoomCategory> getAllRoomCategories() {
        return (List<RoomCategory>) roomCategoryRepository.findAllByOrderByName();
    }
}
