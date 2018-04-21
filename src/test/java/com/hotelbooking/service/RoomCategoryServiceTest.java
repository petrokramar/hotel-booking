package com.hotelbooking.service;

import com.hotelbooking.entity.RoomCategory;
import com.hotelbooking.entity.request.RoomCategoryRequest;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.RoomCategoryRepository;
import com.hotelbooking.service.impl.RoomCategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
        RoomCategory roomCategoryOne = new RoomCategory(ROOM_CATEGORY_ONE_ID, "Room category one name",
                "Room category one description" );
        expectedRoomCategories.add(roomCategoryOne);
        RoomCategory roomCategoryTwo = new RoomCategory(ROOM_CATEGORY_TWO_ID, "Room category two name",
                "Room category two description" );
        expectedRoomCategories.add(roomCategoryTwo);
        RoomCategory roomCategoryThree = new RoomCategory(ROOM_CATEGORY_THREE_ID, "Room category three name",
                "Room category three description" );
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
        RoomCategory expectedRoomCategory = new RoomCategory(ROOM_CATEGORY_ONE_ID, "Room category name",
                "Room category description" );
        given(roomCategoryRepository.findOne(ROOM_CATEGORY_ONE_ID)).willReturn(expectedRoomCategory);

        //when
        RoomCategory actualRoomCategory = roomCategoryService.getRoomCategory(ROOM_CATEGORY_ONE_ID);

        //then
        assertEquals(expectedRoomCategory, actualRoomCategory);
        verify(roomCategoryRepository).findOne(ROOM_CATEGORY_ONE_ID);
        verifyNoMoreInteractions(roomCategoryRepository);
    }

    @Test(expected = DataNotFoundException.class)
    public void getRoomCategoryNotFound() {

        // given
        given(roomCategoryRepository.findOne(ROOM_CATEGORY_ONE_ID)).willReturn(null);

        //when
        RoomCategory roomCategory = roomCategoryService.getRoomCategory(ROOM_CATEGORY_ONE_ID);

        fail();
    }

    @Test
    public void saveRoomCategory() {

        // given
        RoomCategoryRequest request = new RoomCategoryRequest(ROOM_CATEGORY_ONE_ID, "Room category name",
                "Room category description");
        RoomCategory expectedRoomCategory = new RoomCategory(ROOM_CATEGORY_ONE_ID, "Room category name",
                "Room category description" );
        given(roomCategoryRepository.save(expectedRoomCategory)).willReturn(expectedRoomCategory);

        //when
        RoomCategory actualRoomCategory = roomCategoryService.saveRoomCategory(request);

        //then
        assertEquals(expectedRoomCategory, actualRoomCategory);
        verify(roomCategoryRepository).save(expectedRoomCategory);
        verifyNoMoreInteractions(roomCategoryRepository);
    }
}