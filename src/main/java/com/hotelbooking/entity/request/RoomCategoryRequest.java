package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
public class RoomCategoryRequest {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @JsonCreator
    public RoomCategoryRequest(@JsonProperty("id") String id, @JsonProperty("name") String name,
                               @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
