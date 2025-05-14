package com.booking.model;

import java.io.Serializable;
import java.util.jar.Attributes.Name;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SeatsTable")
public class Seat{
	
    @Id
	private Integer seatId;
    
	@Column(length = 3)
	private Integer seatNumber;
	
	@Column(length = 20)
	private String seatType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bus_id")
	@JsonBackReference
	private Bus bus;
	
	@Column(length = 7)
	private boolean status=false;
	
	@OneToOne(mappedBy = "seat",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	@JsonIgnoreProperties
	private Passanger passanger;

	public Seat(Integer seatId, Integer seatNumber, String seatType) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
	}
	
	public Seat() {
		
	}
	
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Passanger getPassanger() {
		return passanger;
	}

	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatNumber=" + seatNumber + ", seatType=" + seatType + ", bus=" 
				+ ", status=" + status + ", passanger="  + "]";
	}
	
	
	
}
