package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.model.Passanger;
import com.booking.model.Seat;

@Repository
public interface PassangersRepository extends JpaRepository<Passanger, Integer> {

	@Query(value = "SELECT * FROM seats_table WHERE seat_id= ?1", nativeQuery = true)
	public Seat getSeatFromPassanger(Integer seatId);
}
