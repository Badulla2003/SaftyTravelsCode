package com.booking.model;

import lombok.Data;

@Data
public class RouteBusDetails {
         String startingPoint;
         String destinationPoint;
         BusDetails busDetails;
}
