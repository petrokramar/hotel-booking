package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hotels", schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    private City city;
    @Enumerated(EnumType.STRING)
    private HotelCategory category;
}
