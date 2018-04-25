package com.hotelbooking.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class ApiError {
    //TODO Change LocalDateTime to String
    private LocalDateTime date;
    private int status;
    private String error;
    private String message;
    private String path;
    private String method;
}
