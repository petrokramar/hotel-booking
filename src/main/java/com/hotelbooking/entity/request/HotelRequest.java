package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
public class HotelRequest {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String cityId;

    @JsonCreator
    public HotelRequest(@JsonProperty("id") String id, @JsonProperty("name") String name,
                        @JsonProperty("cityId") String cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }
}
