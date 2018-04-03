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

    private final int ID_ONE = 1;
    private final int ID_TWO = 2;
    private final int ID_THREE = 3;
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
        roomCategoryOne.setId(ID_ONE);
        roomCategoryOne.setName("Room category 1");
        roomCategoryOne.setDescription("Room category 1 description");
        expectedRoomCategories.add(roomCategoryOne);
        RoomCategory roomCategoryTwo = new RoomCategory();
        roomCategoryTwo.setId(ID_TWO);
        roomCategoryTwo.setName("Room category 2");
        roomCategoryTwo.setDescription("Room category 2 description");
        expectedRoomCategories.add(roomCategoryTwo);
        RoomCategory roomCategoryThree = new RoomCategory();
        roomCategoryThree.setId(ID_THREE);
        roomCategoryThree.setName("Room category 3");
        roomCategoryThree.setDescription("Room category 3 description");
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
        expectedRoomCategory.setId(ID_ONE);
        expectedRoomCategory.setName("Room category 1");
        expectedRoomCategory.setDescription("Room category 1 description");
        given(roomCategoryRepository.findOne(ID_ONE)).willReturn(expectedRoomCategory);

        //when
        RoomCategory actualRoomCategory = roomCategoryService.getRoomCategory(ID_ONE);

        //then
        assertEquals(expectedRoomCategory, actualRoomCategory);
        verify(roomCategoryRepository).findOne(ID_ONE);
        verifyNoMoreInteractions(roomCategoryRepository);
    }

    @Test
    public void saveRoomCategory() {

        // given
        RoomCategoryRequest request = new RoomCategoryRequest("1", "Room category 1",
                "Room category 1 description");
        RoomCategory expectedRoomCategory = new RoomCategory();
        expectedRoomCategory.setId(ID_ONE);
        expectedRoomCategory.setName("Room category 1");
        expectedRoomCategory.setDescription("Room category 1 description");
        given(roomCategoryRepository.save(expectedRoomCategory)).willReturn(expectedRoomCategory);

        //when
        RoomCategory actualRoomCategory = roomCategoryService.saveRoomCategory(request);

        //then
        assertEquals(expectedRoomCategory, actualRoomCategory);
        verify(roomCategoryRepository).save(expectedRoomCategory);
        verifyNoMoreInteractions(roomCategoryRepository);
    }
}