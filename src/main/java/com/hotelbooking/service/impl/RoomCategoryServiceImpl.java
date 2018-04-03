package com.hotelbooking.service.impl;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.request.RoomCategoryRequest;
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

    @Override
    public RoomCategory getRoomCategory(int id) {
        return roomCategoryRepository.findOne(id);
    }

    @Override
    public RoomCategory saveRoomCategory(RoomCategoryRequest request) {
        RoomCategory roomCategory = new RoomCategory();
        roomCategory.setId(request.getId());
        roomCategory.setName(request.getName());
        roomCategory.setDescription(request.getDescription());
        return roomCategoryRepository.save(roomCategory);
    }

}
