package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cities", schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    private Country country;
}
