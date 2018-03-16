package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
public class HotelRequest {

    @NotEmpty
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String cityId;

    @JsonCreator
    public HotelRequest() {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }
}
