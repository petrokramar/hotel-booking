package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
public class HotelRequest {

    @NotNull
    private int id;

    @NotEmpty
    private String name;

    @NotNull
    private int cityId;

    @JsonCreator
    public HotelRequest(@JsonProperty(value = "id", required = true) int id, @JsonProperty("name") String name,
                        @JsonProperty(value = "cityId", required = true) int cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }
}
