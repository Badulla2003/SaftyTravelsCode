package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.model.Seat;

@Repository
public interface SeatsRepository extends JpaRepository<Seat, Integer> {

	@Query(value = "SELECT * FROM seats_table WHERE bus_id = ?1 AND seat_id = ?2", nativeQuery = true)
	public Seat getSeatByBusIdAndSeatId(Integer seatId, Integer busId);

	@Query(value = "SELECT * FROM seats_table WHERE bus_id= ?1", nativeQuery = true)
	public List<Seat> getSeatsDataByBusId(Integer BusId);

}
