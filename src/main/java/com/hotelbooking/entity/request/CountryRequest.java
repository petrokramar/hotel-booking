package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
public class CountryRequest {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @JsonCreator
    public CountryRequest(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
