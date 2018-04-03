package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
public class BookingRequest {

    @NotNull
    private int id;

    @NotNull
    private int roomId;

    @NotEmpty
    private String username;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateBegin;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateEnd;

    @NotEmpty
    private List<Integer> hotelServiceIds;

    @JsonCreator
    public BookingRequest(@JsonProperty(value = "id", required = true) int id,
                          @JsonProperty(value = "roomId", required = true) int roomId,
                          @JsonProperty("username") String username,
                          @JsonProperty("dateBegin") Date dateBegin, @JsonProperty("dateEnd") Date dateEnd,
                          @JsonProperty("hotelServiceIds") List<Integer> hotelServiceIds) {
        this.id = id;
        this.roomId = roomId;
        this.username = username;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.hotelServiceIds = hotelServiceIds;
    }
}