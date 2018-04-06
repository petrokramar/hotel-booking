package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "room_categories", schema = "BOOKING_HOTELS_SCHEMA")
@Data
//TODO Change to RoomType
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
//    private int price;
}
