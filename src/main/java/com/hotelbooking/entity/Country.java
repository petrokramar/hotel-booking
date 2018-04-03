package com.hotelbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "countries", schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
