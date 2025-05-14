package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Bus;
import com.booking.model.Passanger;
import com.booking.model.Route;
import com.booking.model.Seat;
import com.booking.repository.CustomerRepository;
import com.booking.repository.PassangersRepository;
import com.booking.repository.SeatsRepository;

@Service
public class TicketBookingService {

	@Autowired
	BusService busSer;

	@Autowired
	SeatService seatSer;

	@Autowired
	PassangerService passSer;

	@Autowired
	SeatsRepository seatsRep;
	
	@Autowired
	PassangersRepository passangerRep;
	
	@Autowired
	CustomerRepository customerRepository;

	public boolean bookTicket(Integer busId, Integer seatId, Passanger pass) {
		Seat s = seatsRep.getSeatByBusIdAndSeatId(busId ,seatId);
		
		pass.setSeat(s);
		if (s != null) {
			s.setPassanger(pass);
			s.setStatus(true);
			seatsRep.save(s);
	
			System.out.println(pass.getSeat().toString());
			System.out.println("seatHasbeenBooked...");
			return true;
		}
		else {
			System.err.println("no seat found...");
			return false;
		}
	}
	
	public boolean cancellTicket(Integer passangerId) {
	      Seat s=passangerRep.getSeatFromPassanger(passangerId);
	     if(s!=null) {
	    	 s.setPassanger(null);
		      s.setStatus(false);
		      seatsRep.save(s);
		      System.out.println("seat has been cancelled...");  
		      return true;
	     }
	     else {
	    	 System.err.println("TicketBookingService.cancellTicket()");
	    	 return false;
	     }
	}

}
