package com.hotelbooking.entity;

import java.util.Date;
import java.util.List;

public class Booking {
    private long id;
    private Room room;
    private User user;
    private Date dateBegin;
    private Date dateEnd;
    private List<HotelService> services;
}
