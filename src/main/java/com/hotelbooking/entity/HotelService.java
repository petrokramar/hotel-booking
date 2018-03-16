package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hotel_services", schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class HotelService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
//    private int price;
}
