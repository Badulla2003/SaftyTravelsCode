package com.booking.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity(name = "RoutesTable")
@Data
@AllArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "route",sequenceName = "route_seq",allocationSize = 1,initialValue = 1)
	private Integer id;

	@Column(length = 20)
	private String startingPoint;

	@Column(length = 20)
	private String destinationPoint;




	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	@JsonBackReference
	private List<Bus> busList;

	
	public Route() {
		
	}

	public Integer getRouteId() {
		return id;
	}

	public void setRouteId(Integer routeId) {
		this.id = routeId;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	

}
