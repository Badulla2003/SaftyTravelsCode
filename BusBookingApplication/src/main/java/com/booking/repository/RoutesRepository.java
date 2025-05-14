package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.model.Route;

@Repository
public interface RoutesRepository extends JpaRepository<Route, Integer> {

	@Query(value = "SELECT * from routes_table where lower(starting_point)=?1 and lower(destination_point)=?2", nativeQuery = true)
	public Route getRouteIdByPoints(String starting, String ending);
}
