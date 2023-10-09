package com.gl.ticketTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.ticketTracker.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	List<Ticket> findByTitleContainsAndDescriptionContainsAllIgnoreCase(String name,String author);
	
}
