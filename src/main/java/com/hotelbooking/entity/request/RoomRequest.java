package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
public class RoomRequest {

    @NotEmpty
    private String id;

    @NotEmpty
    private String number;

    @NotEmpty
    private String hotelId;

    @NotEmpty
    private String roomCategoryId;

    @JsonCreator
    public RoomRequest() {
        this.id = id;
        this.number = number;
        this.hotelId = hotelId;
        this.roomCategoryId = roomCategoryId;
    }
}
