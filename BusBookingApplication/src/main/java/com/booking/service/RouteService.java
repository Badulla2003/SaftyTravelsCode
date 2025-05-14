package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Route;
import com.booking.repository.RoutesRepository;

@Service
public class RouteService {
	@Autowired
	RoutesRepository routeRep;
	
	public boolean saveRoute(Route route) {
	  Route	r=routeRep.save(route);
	  if(r!=null) {
		  return true;
	  }
	  return false;
	}
	
	public void remove(Integer routeId) {
		  routeRep.deleteById(routeId);	
		  System.out.println("RouteService.removeRoute()");
		}
	
	public Integer getRoutesIdByPoints(String starting,String ending) {
		Route i=routeRep.getRouteIdByPoints(starting, ending);
		if(i!=null) {
			return i.getId();
		}
		return 0;
	}
}
