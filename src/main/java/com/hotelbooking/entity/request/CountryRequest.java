package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
public class CountryRequest {

    @NotNull
    private int id;

    @NotEmpty
    private String name;

    @JsonCreator
    public CountryRequest(@JsonProperty(value = "id", required = true) int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
