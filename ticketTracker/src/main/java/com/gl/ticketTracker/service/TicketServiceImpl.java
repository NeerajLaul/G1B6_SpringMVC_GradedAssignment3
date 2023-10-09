package com.gl.ticketTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ticketTracker.entity.Ticket;
import com.gl.ticketTracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		List<Ticket> tickets = ticketRepository.findAll();
		return tickets;
	}

	@Override
	public void save(Ticket theTicket) {
		// TODO Auto-generated method stub
		ticketRepository.save(theTicket);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(theId);
		
	}

	@Override
	public List<Ticket> searchBy(String title, String description) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = 
				ticketRepository.findByTitleContainsAndDescriptionContainsAllIgnoreCase(title, description);
		return tickets;
	}

	@Override
	public Ticket findbById(int theId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(theId).get();
	}
}
