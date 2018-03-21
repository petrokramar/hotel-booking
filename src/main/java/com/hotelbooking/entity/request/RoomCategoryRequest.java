package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    public RoomCategoryRequest() {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
