package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
public class RoomRequest {

    @NotNull
    private int id;

    @NotNull
    private int number;

    @NotNull
    private int hotelId;

    @NotNull
    private int roomCategoryId;

    @JsonCreator
    public RoomRequest(@JsonProperty(value = "id", required = true) int id,
                       @JsonProperty(value = "number", required = true) int number,
                       @JsonProperty(value = "hotelId", required = true) int hotelId,
                       @JsonProperty(value = "roomCategoryId", required = true) int roomCategoryId) {
        this.id = id;
        this.number = number;
        this.hotelId = hotelId;
        this.roomCategoryId = roomCategoryId;
    }
}
