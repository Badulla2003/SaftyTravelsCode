package com.booking.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customersTable")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "cust",sequenceName = "customer_seq",allocationSize = 1,initialValue = 1)
	private Integer customerId;

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

	public Customer() {

	}
	
	

	public Customer(Integer customerId, String name, String email, Integer age, Long phoneNumber, String place,
			String city) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.place = place;
		this.city = city;
	}



	public Customer(String name, String email, Integer age, Long phoneNumber, String place, String city) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.place = place;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}



	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + ", place=" + place + ", city=" + city + "]";
	}
	
	

}
