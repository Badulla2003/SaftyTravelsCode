package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Passanger;
import com.booking.repository.PassangersRepository;

@Service
public class PassangerService {
	
	@Autowired
	PassangersRepository passangerRep;
	
	public void savePassanger(Passanger pass) {
		passangerRep.save(pass);
		System.out.println("Passanger saved successfully....");
	}
 
}
