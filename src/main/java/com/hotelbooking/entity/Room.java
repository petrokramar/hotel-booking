package com.hotelbooking.entity;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int number;
    @ManyToOne
    private RoomCategory roomCategory;
}
