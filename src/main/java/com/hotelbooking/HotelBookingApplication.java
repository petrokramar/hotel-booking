package com.hotelbooking;

import com.hotelbooking.entity.*;
import com.hotelbooking.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HotelBookingApplication implements CommandLineRunner{

	@Inject
	UserRepository userRepository;

    @Inject
    AuthorityRepository authorityRepository;

    @Inject
    RoomCategoryRepository roomCategoryRepository;

    @Inject
    RoomRepository roomRepository;

    @Inject
    HotelServiceRepository hotelServiceRepository;

    @Inject
    BookingRepository bookingRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUsername("bob");
        user1.setPassword("{noop}1");
        user1.setEnabled(true);
        user1.setFirstName("Bob");
        user1.setLastName("Marley");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("james");
        user2.setPassword("{noop}1");
        user2.setEnabled(true);
        user2.setFirstName("James");
        user2.setLastName("Bond");
        userRepository.save(user2);

        Authority authority1 = new Authority();
        authority1.setUsername("bob");
        authority1.setAuthority("ROLE_ADMIN");
        authorityRepository.save(authority1);

        RoomCategory category1 = new RoomCategory();
        category1.setName("First");
        category1.setDescription("First category");
        category1.setPrice(10000);
        roomCategoryRepository.save(category1);

        RoomCategory category2 = new RoomCategory();
        category2.setName("Second");
        category2.setDescription("Second category");
        category2.setPrice(8000);
        roomCategoryRepository.save(category2);

        Room room1 = new Room();
        room1.setNumber(101);
        room1.setRoomCategory(category1);
        roomRepository.save(room1);

        Room room2 = new Room();
        room2.setNumber(201);
        room2.setRoomCategory(category2);
        roomRepository.save(room2);

        HotelService service1 = new HotelService();
        service1.setName("Breakfast");
        service1.setPrice(2000);
        hotelServiceRepository.save(service1);

        HotelService service2 = new HotelService();
        service2.setName("Cleaning room");
        service2.setPrice(1000);
        hotelServiceRepository.save(service2);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Booking booking1 = new Booking();
        booking1.setRoom(room1);
        booking1.setUser(user1);
        List<HotelService> services1 = new ArrayList<>();
        services1.add(service1);
        services1.add(service2);
        booking1.setServices(services1);
        booking1.setDateBegin(format.parse("25.02.2018"));
        booking1.setDateEnd(format.parse("28.02.2018"));
        bookingRepository.save(booking1);

        Booking booking2 = new Booking();
        booking2.setRoom(room2);
        booking2.setUser(user2);
        List<HotelService> services2 = new ArrayList<>();
        services2.add(service1);
        booking2.setServices(services2);
        booking2.setDateBegin(format.parse("28.02.2018"));
        booking2.setDateEnd(format.parse("05.03.2018"));
        bookingRepository.save(booking2);
	}
}