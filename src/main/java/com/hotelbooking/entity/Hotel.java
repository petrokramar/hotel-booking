package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    private City city;
}
