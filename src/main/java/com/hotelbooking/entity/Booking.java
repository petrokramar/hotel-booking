package com.hotelbooking.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "BOOKING_HOTELS_SCHEMA")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Room room;
    @ManyToOne
    private User user;
    private Date dateBegin;
    private Date dateEnd;
    @ManyToMany
    @JoinTable(
            name = "booking_services", schema = "BOOKING_HOTELS_SCHEMA",
            joinColumns = { @JoinColumn(name = "booking_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") })
    private List<AdditionalService> additionalServices;
}
