package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "rooms")
@Table(name = "rooms", schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int number;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private RoomCategory roomCategory;
}
