package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    public CityRequest(@JsonProperty("id") String id, @JsonProperty("name") String name,
                       @JsonProperty("countryId") String countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }
}
