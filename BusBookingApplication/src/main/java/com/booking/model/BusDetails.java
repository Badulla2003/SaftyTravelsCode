package com.booking.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BusDetails {

	String busNumber;

	String busType;

	Integer doubleSeaters;

	Integer doubleSleepers;

	String dtime;

	Integer singleSeaters;

	Integer singleSleepers;

	Integer startsAt;

	String stime;

	LocalDate travelDate;

	String travelsName;

}
