package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.model.Ticket;

public interface TicketService extends JpaRepository<Ticket, Long> {

}
