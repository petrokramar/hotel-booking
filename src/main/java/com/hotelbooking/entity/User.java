package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "users")
@Table(name = "users", schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class User {
    @Id
    private String username;
    private String password;
    private boolean enabled;
    private String firstName;
    private String lastName;
}
