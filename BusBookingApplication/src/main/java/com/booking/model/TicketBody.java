package com.booking.model;

import java.util.List;

public class TicketBody {
	
	private List<TicketData> ticketData;
	
	private Integer BusId;


	public Integer getBusId() {
		return BusId;
	}

	public void setBusId(Integer busId) {
		BusId = busId;
	}

	public TicketBody(List<TicketData> ticketData, Integer busId) {
		super();
		this.ticketData = ticketData;
		BusId = busId;
	}

	public TicketBody() {
		super();
	}
	
	public List<TicketData> getTicketData() {
		return ticketData;
	}

	public void setTicketData(List<TicketData> ticketData) {
		this.ticketData = ticketData;
	}
	
	
	

}
