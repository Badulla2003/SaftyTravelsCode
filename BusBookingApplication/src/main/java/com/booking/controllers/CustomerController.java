package com.booking.controllers;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.Bus;
import com.booking.model.Customer;
import com.booking.model.Passanger;
import com.booking.model.Seat;
import com.booking.model.TicketBody;
import com.booking.model.TicketData;
import com.booking.service.BusService;
import com.booking.service.CustomerService;
import com.booking.service.RouteService;
import com.booking.service.SeatService;
import com.booking.service.TicketBookingService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	BusService busService;

	@Autowired
	SeatService seatService;

	@Autowired
	RouteService routeService;

	@Autowired
	TicketBookingService ticketService;
	
	@Autowired
	CustomerService customerService;

	@GetMapping("/getBusData")
	public ResponseEntity<List<Bus>> getBusesData(@RequestParam String startingPoint,
			@RequestParam String destinationPoint,@RequestParam String travelsDate) {

		System.out.println("hi");
		if (startingPoint != null && destinationPoint != null) {
			System.out.println("Starting :" + startingPoint+" "+"destination point :"+destinationPoint);
			Integer routeId = routeService.getRoutesIdByPoints(startingPoint.toLowerCase(), destinationPoint.toLowerCase());
			System.out.println("routeId is : " + routeId);
			List<Bus> busList = busService.getBusDataByRouteId(routeId);
			if (!busList.isEmpty()) {
				return new ResponseEntity<List<Bus>>(busList, HttpStatus.OK);

			} else {
				return null;
			}
		} else {
			System.out.println("Starting :" + startingPoint);
			return null;
		}

	}

	@GetMapping("/getSeatsData")
	public List<Seat> getSeatsDataOfBus(@RequestParam("busId") Integer BusId) {
		try {
			List<Seat> seatList = seatService.getSeatsDataByBusId(BusId);
			return seatList;
		} catch (NullPointerException e) {
			return null;
		}

	}


	
	@PostMapping("/bookTickets")
	public boolean bookSeat(@RequestBody TicketBody ticketData
			) {
		
        List<TicketData> td=ticketData.getTicketData();
        Integer busId=ticketData.getBusId();
        boolean saved=true;
        for(TicketData t:td) {
        	Customer customer=t.getPassenger();
        	Passanger passanger = new Passanger(customer.getName(),customer.getEmail(),customer.getAge(),customer.getPhoneNumber(),customer.getPlace(),customer.getCity());
        	
        	Integer seatId=t.getSeat();
        	if(customer==null || passanger==null) {
        		saved=false;
        		break;
        	}
        	boolean b = ticketService.bookTicket(busId, seatId,passanger );
    		if (b)
    			continue;
    		else saved=false;
        }
        return saved;


	}
	
	

	@PostMapping("/cancelTicket")
	public boolean cancelTicket(@RequestParam("busId") Integer busId, @RequestParam("seatId") Integer seatId,
			@RequestParam("passangerId") Integer passangerId, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("age") Integer age,
			@RequestParam("phoneNumber") Long phoneNumber, @RequestParam("city") String city,
			@RequestParam("place") String place) {
		{
			Passanger passanger = new Passanger(passangerId, name, email, age, phoneNumber, city, place);
			boolean b = ticketService.cancellTicket(passangerId);
			if (b)
				return true;
			else
				return false;
		}

	}
	
	@PostMapping("/addCustomer")
	public boolean addCustomer(@RequestBody Customer customer) {
		boolean b=customerService.saveCustomer(customer);
		if(b) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/removeCustomer")
	public boolean removeCustomer(@RequestParam("customerId") Integer customerId) {
		System.out.println("CustomerController.removeCustomer()");
		boolean b=customerService.deleteCustomer(customerId);
		if(b) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/getAllSavedPassangers")
	public List<Customer> getAllSavedPassangers(){
		List<Customer> list=customerService.getAllSavedPassangers();
		if(list!=null) {
			return list;
		}
		return null;
	}
}
