package com.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.booking.model.Bus;
import com.booking.model.Passanger;
import com.booking.model.Route;
import com.booking.repository.BusRepository;
import com.booking.service.BusService;
import com.booking.service.RouteService;
import com.booking.service.TicketBookingService;

@SpringBootApplication
public class BusBookingApplications {
	
    @Autowired
    BusService busService;
    
    @Autowired
     RouteService routeService;
    
    @Autowired
    TicketBookingService ticketBookingService;
    

	public static void main(String[] args) {
		SpringApplication.run(BusBookingApplications.class, args);

		
	}
	


	
}
