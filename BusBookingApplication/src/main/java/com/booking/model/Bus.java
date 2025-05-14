package com.booking.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "BusesTable")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "bus",sequenceName = "bus_seq",allocationSize = 1,initialValue = 1)
	private Integer id;
	
	@Column(length = 20)
	private String busNumber;
	
	@Column(length = 25)
	private String busType;
	
	@Column(length = 3)
	private Integer busCapacity;
	
	@Column(length = 3)
	private Integer singleSeaters;
	
	@Column(length = 3)
	private Integer doubleSeaters;
	
	@Column(length = 3)
	private Integer singleSleepers;
	
	@Column(length = 3)
	private Integer doubleSleepers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "routes_id")
	private Route route;
	
	@OneToMany(mappedBy = "bus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Seat> seats ;
	
	@Column(length = 25)
	String sTime;
	
	@Column(length = 25)
	String dTime;
	
	@Column(length = 15)
	LocalDate travelsDate;
	
	@Column(length = 30)
	String travelsName;
	
	@Column(length = 3)
	Integer startsAt;
	 	
}
