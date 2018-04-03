package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    public RoomRequest(@JsonProperty("id") String id, @JsonProperty("number") String number,
                       @JsonProperty("hotelId") String hotelId, @JsonProperty("roomCategoryId") String roomCategoryId) {
        this.id = id;
        this.number = number;
        this.hotelId = hotelId;
        this.roomCategoryId = roomCategoryId;
    }
}
