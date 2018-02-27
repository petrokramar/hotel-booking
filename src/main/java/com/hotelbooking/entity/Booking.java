package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Room room;
    @ManyToOne
    private User user;
    private Date dateBegin;
    private Date dateEnd;
    @ManyToMany
    @JoinTable(
            name = "booking_service",
            joinColumns = { @JoinColumn(name = "booking_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") })
    private List<HotelService> services;
}
