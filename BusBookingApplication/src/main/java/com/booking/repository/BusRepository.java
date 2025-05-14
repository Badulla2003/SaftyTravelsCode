package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.booking.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

	@Query(value = "SELECT * FROM buses_table WHERE routes_id=?1", nativeQuery = true)
	public List<Bus> getBusDataByRouteId(Integer routeId);

}
