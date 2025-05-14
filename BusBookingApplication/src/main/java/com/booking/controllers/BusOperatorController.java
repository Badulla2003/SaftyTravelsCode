package com.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.Bus;
import com.booking.model.BusDetails;
import com.booking.model.Route;
import com.booking.model.RouteBusDetails;
import com.booking.repository.BusRepository;
import com.booking.repository.RoutesRepository;
import com.booking.service.BusService;
import com.booking.service.RouteService;
import com.booking.service.SeatService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BusOperatorController {
	

	@Autowired
	RouteService routeService;

	@Autowired
	BusService busService;

	@Autowired
	SeatService seatService;

	@Autowired
	RoutesRepository routeRep;
	
	@Autowired
	BusRepository busRep;

	@PostMapping("/addBusToRoute")
	public boolean addRouteAndBus(@RequestBody RouteBusDetails routeBusDetails) {
		System.out.println(routeBusDetails);

		String spoint = routeBusDetails.getStartingPoint().toLowerCase();
		String dpoint = routeBusDetails.getDestinationPoint().toLowerCase();
		BusDetails bd = routeBusDetails.getBusDetails();
		Route route = new Route();
		route.setStartingPoint(spoint);
		route.setDestinationPoint(dpoint);

		Bus b = new Bus();
		b.setBusNumber(bd.getBusNumber());
		b.setBusType(bd.getBusType());
		b.setDTime(bd.getDtime());
		b.setSTime(bd.getStime());
		b.setSingleSeaters(bd.getSingleSeaters());
		b.setDoubleSeaters(bd.getDoubleSeaters());
		b.setSingleSleepers(bd.getSingleSleepers());
		b.setDoubleSleepers(bd.getDoubleSleepers());
		b.setTravelsDate(bd.getTravelDate());
		b.setTravelsName(bd.getTravelsName());
		b.setStartsAt(bd.getStartsAt());
		
	
		Route r = routeRep.getRouteIdByPoints(spoint, dpoint);

		if (r == null) {
			r = routeRep.save(route);
			System.out.println("new Route saved and bus also saved");
			b.setRoute(r);
			busService.saveBus(b);
		}
		else {
			b.setRoute(r);
			System.out.println("bus saved for existing route");
			busService.saveBus(b);
		}
		
		if(b !=null && r!=null) {
			System.out.println("bus Saved Successfully");
			return true;
		}

		return false;
	}
	
	@GetMapping("/sayHi")
	public String sayHi() {
		System.out.println("Working with the port and saying hi");
		return "hi";
	}

}
