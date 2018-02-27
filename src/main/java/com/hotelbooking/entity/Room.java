package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int number;
    @ManyToOne
    private RoomCategory roomCategory;
}
