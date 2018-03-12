package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authorities", schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String authority;
}
