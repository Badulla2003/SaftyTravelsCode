package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Seat;
import com.booking.repository.SeatsRepository;

@Service
public class SeatService {
       
	@Autowired
	SeatsRepository seatRep;
	
	public void saveSeat(Seat seat) {
		seatRep.save(seat);
		System.out.println("seat Booked...");
	}
	
	public List<Seat> getSeatsDataByBusId(Integer BusId) throws NullPointerException{
		System.out.println("SeatService.getSeatsDataByBusId()");
		System.out.println(BusId);
		List<Seat> list=seatRep.getSeatsDataByBusId(BusId);
		if(list!=null) {
			return list;
		}
		else {
			throw new NullPointerException();
		}
	}
}
