package com.gl.ticketTracker.service;

import java.util.List;

import com.gl.ticketTracker.entity.Ticket;

public interface TicketService {
	
	public List<Ticket> findAll();
	
	public Ticket findbById(int theId);
	
	public void save(Ticket theTicket);
	
	public void deleteById(int theId);
	
	public List<Ticket> searchBy(String title, String description);
	
}
