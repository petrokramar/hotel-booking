package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
public class CityRequest {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String countryId;

    @JsonCreator
    public CityRequest() {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }
}
