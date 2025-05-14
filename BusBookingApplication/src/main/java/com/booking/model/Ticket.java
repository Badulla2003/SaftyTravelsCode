package com.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ticketsTable")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	@Column(length = 15)
	private Integer BusId;
	
	@Column(length = 15)
	private Integer seatId;
	
	@Column(length = 15)
	private Integer passangerId;
	
}
