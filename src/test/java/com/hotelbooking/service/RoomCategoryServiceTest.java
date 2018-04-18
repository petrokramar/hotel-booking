package com.hotelbooking.service;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.request.RoomCategoryRequest;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.service.impl.RoomCategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class RoomCategoryServiceTest {

    private final int ROOM_CATEGORY_ONE_ID = 1;
    private final int ROOM_CATEGORY_TWO_ID = 2;
    private final int ROOM_CATEGORY_THREE_ID = 3;
    private RoomCategoryRepository roomCategoryRepository;
    private RoomCategoryService roomCategoryService;

    @Before
    public void setUp() {
        roomCategoryRepository = mock(RoomCategoryRepository.class);
        roomCategoryService = new RoomCategoryServiceImpl(roomCategoryRepository);
    }


    @Test
    public void getAllRoomCategories() {

        // given
        List<RoomCategory> expectedRoomCategories = new ArrayList<>();
        RoomCategory roomCategoryOne = new RoomCategory();
        roomCategoryOne.setId(ROOM_CATEGORY_ONE_ID);
        roomCategoryOne.setName("Room category name 1");
        roomCategoryOne.setDescription("Room category description 1");
        expectedRoomCategories.add(roomCategoryOne);
        RoomCategory roomCategoryTwo = new RoomCategory();
        roomCategoryTwo.setId(ROOM_CATEGORY_TWO_ID);
        roomCategoryTwo.setName("Room category name 2");
        roomCategoryTwo.setDescription("Room category description 2");
        expectedRoomCategories.add(roomCategoryTwo);
        RoomCategory roomCategoryThree = new RoomCategory();
        roomCategoryThree.setId(ROOM_CATEGORY_THREE_ID);
        roomCategoryThree.setName("Room category name 3");
        roomCategoryThree.setDescription("Room category description 3");
        expectedRoomCategories.add(roomCategoryThree);
        given(roomCategoryRepository.findAllByOrderByName()).willReturn(expectedRoomCategories);

        //when
        List<RoomCategory> actualRoomCategories = roomCategoryService.getAllRoomCategories();

        //then
        assertEquals(expectedRoomCategories, actualRoomCategories);
        verify(roomCategoryRepository).findAllByOrderByName();
        verifyNoMoreInteractions(roomCategoryRepository);
    }

    @Test
    public void getRoomCategory() {

        // given
        RoomCategory expectedRoomCategory = new RoomCategory();
        expectedRoomCategory.setId(ROOM_CATEGORY_ONE_ID);
        expectedRoomCategory.setName("Room category name");
        expectedRoomCategory.setDescription("Room category description");
        given(roomCategoryRepository.findOne(ROOM_CATEGORY_ONE_ID)).willReturn(expectedRoomCategory);

        //when
        RoomCategory actualRoomCategory = roomCategoryService.getRoomCategory(ROOM_CATEGORY_ONE_ID);

        //then
        assertEquals(expectedRoomCategory, actualRoomCategory);
        verify(roomCategoryRepository).findOne(ROOM_CATEGORY_ONE_ID);
        verifyNoMoreInteractions(roomCategoryRepository);
    }

    @Test
    public void saveRoomCategory() {

        // given
        RoomCategoryRequest request = new RoomCategoryRequest(ROOM_CATEGORY_ONE_ID, "Room category name",
                "Room category description");
        RoomCategory expectedRoomCategory = new RoomCategory();
        expectedRoomCategory.setId(ROOM_CATEGORY_ONE_ID);
        expectedRoomCategory.setName("Room category name");
        expectedRoomCategory.setDescription("Room category description");
        given(roomCategoryRepository.save(expectedRoomCategory)).willReturn(expectedRoomCategory);

        //when
        RoomCategory actualRoomCategory = roomCategoryService.saveRoomCategory(request);

        //then
        assertEquals(expectedRoomCategory, actualRoomCategory);
        verify(roomCategoryRepository).save(expectedRoomCategory);
        verifyNoMoreInteractions(roomCategoryRepository);
    }
}