package com.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Bus;
import com.booking.model.BusDetails;
import com.booking.model.Seat;
import com.booking.repository.BusRepository;

@Service
public class BusService {
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	SeatService seatService;
	
	public void saveBus(Bus bus) {
	
		Bus b=bus;
		busRepository.save(b);
		List<Seat> seatList=new ArrayList<Seat>();
		if(b!=null) {
		   int seatNo=1;
		   for(int i=1;i<=bus.getSingleSeaters();i++) {
			   Integer seatId=Integer.parseInt(bus.getId()+""+seatNo);
			   Seat seat=new Seat(seatId, seatNo,"singleSeater");
			   seat.setBus(bus);
			   seatList.add(seat);
			   seatService.saveSeat(seat);
			   seatNo++;
		   }
		   for(int i=1;i<=bus.getDoubleSeaters();i++) {
			   Integer seatId=Integer.parseInt(bus.getId()+""+seatNo);
			   Seat seat=new Seat(seatId, seatNo,"doubleSeater");
			   seat.setBus(bus);
			   seatList.add(seat);
			   seatService.saveSeat(seat);
			   seatNo++;
		   }
		   for(int i=1;i<=bus.getSingleSleepers();i++) {
			   Integer seatId=Integer.parseInt(bus.getId()+""+seatNo);
			   Seat seat=new Seat(seatId, seatNo,"singleSleepers");
			   seat.setBus(bus);
			   seatList.add(seat);
			   seatService.saveSeat(seat);
			   seatNo++;
		   }
		   for(int i=1;i<=bus.getDoubleSleepers();i++) {
			   Integer seatId=Integer.parseInt(bus.getId()+""+seatNo);
			   Seat seat=new Seat(seatId, seatNo,"doubleSleeper");
			   seat.setBus(bus);
			   seatList.add(seat);
			   seatService.saveSeat(seat);
			   seatNo++;
		   }
		   seatList.forEach(System.out::println);
		   b.setSeats(seatList);
		  busRepository.save(b);
		  System.out.println("Bus saved Successfully....");
		   }
		
	}
	
	public void removeBus(Integer busId) {
		busRepository.deleteById(busId);
		System.out.println("BusService.removeBus()");
	}
	
	public List<Bus> getBusDataByRouteId(Integer routeId){
		List<Bus> busList=busRepository.getBusDataByRouteId(routeId);
		return busList;
	}
	

}
