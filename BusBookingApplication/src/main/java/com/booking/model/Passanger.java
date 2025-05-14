package com.booking.model;

import java.io.Serializable;
import java.util.jar.Attributes.Name;

import org.hibernate.annotations.GeneratorType;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PassangersTable")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
public class Passanger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	   @SequenceGenerator(name = "pass",sequenceName = "pasanger_seq",allocationSize = 1,initialValue = 1)
	private Integer passangerId;

	@Column(length = 20)
	private String name;

	@Column(length = 20)
	private String email;

	@Column(length = 3)
	private Integer age;

	@Column(length = 10)
	private Long phoneNumber;

	@Column(length = 20)
	private String place;

	@Column(length = 20)
	private String city;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "seat_id")
	private Seat seat;


	public Passanger(String name, String email, Integer age, Long phoneNumber, String place, String city) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.place = place;
		this.city = city;
	}


	public Passanger(Integer passangerId, String name, String email, Integer age, Long phoneNumber, String place,
			String city) {
		super();
		this.passangerId = passangerId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.place = place;
		this.city = city;
	}






	
}
