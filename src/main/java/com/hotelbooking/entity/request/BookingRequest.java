package com.hotelbooking.entity.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Getter
@EqualsAndHashCode
public class BookingRequest {

    @NotNull
    private int id;

    @NotNull
    private int roomId;

    @NotEmpty
    private String username;

    @NotNull
    private int totalSum;

    @NotNull
    private int persons;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateBegin;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateEnd;

    @JsonCreator
    public BookingRequest(@JsonProperty(value = "id", required = true) int id,
                          @JsonProperty(value = "roomId", required = true) int roomId,
                          @JsonProperty("username") String username,
                          @JsonProperty(value = "totalSum", required = true) int totalSum,
                          @JsonProperty(value = "persons", required = true) int persons,
                          @JsonProperty("dateBegin") Date dateBegin,
                          @JsonProperty("dateEnd") Date dateEnd) {
        this.id = id;
        this.roomId = roomId;
        this.username = username;
        this.totalSum = totalSum;
        this.persons = persons;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }
}