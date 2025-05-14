package com.booking.model;



public class TicketData {
	
	private Customer passenger;
	
	private Integer seat;

	public TicketData(Customer passanger, Integer seat) {
		super();
		this.passenger = passanger;
		this.seat = seat;
	}
	public TicketData( Integer seat,Customer passanger) {
		super();
		this.passenger = passanger;
		this.seat = seat;
	}
	

	public TicketData() {
		super();
	}
	public Customer getPassenger() {
		return passenger;
	}

	public void setPassanger(Customer passanger) {
		this.passenger = passanger;
	}

	public Integer getSeat() {
		return seat;
	}

	@Override
	public String toString() {
		return "TicketData [customer=" + passenger + ", seat=" + seat + "]";
	}

	public void setSeat(Integer busId) {
		this.seat = busId;
	}
	
	

}
