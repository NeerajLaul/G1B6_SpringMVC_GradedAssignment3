package com.gl.ticketTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.gl.ticketTracker.entity.Ticket;
import com.gl.ticketTracker.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@RequestMapping("/list")
	public String listTickets(Model theModel) {
		
		List<Ticket> theTicket = ticketService.findAll();
		
		theModel.addAttribute("Tickets", theTicket);
		
		return "list-Tickets";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Ticket theTicket = new Ticket();
		
		theModel.addAttribute("Ticket", theTicket);
		
		return "Ticket-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") int theId, Model theModel) {
		
		Ticket theTicket = ticketService.findbById(theId);
		
		theModel.addAttribute("Ticket", theTicket);
		
		return "Ticket-form";
	}
	
	@PostMapping("/save")
	public String saveTicket(@RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("description")
	String description, @RequestParam("content") String content) {
		
		System.out.println(id);
		Ticket theTicket;
		if(id!=0)
		{
			theTicket = ticketService.findbById(id);
			theTicket.setTitle(title);
			theTicket.setDescription(description);
			theTicket.setContent(content);
		}
		else
			theTicket = new Ticket(id, title, description, content);
		
		ticketService.save(theTicket);
		
		return "redirect:/tickets/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		
		ticketService.deleteById(theId);
		
		return "redirect:/tickets/list";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("title") String title, @RequestParam("description") String description, Model theModel) {
		
		if(title.trim().isEmpty() && description.trim().isEmpty()) {
			return "redirect:/tickets/list";
		}
		else {
			List<Ticket> theTicket = ticketService.searchBy(title, description);
			
			theModel.addAttribute("Ticket", theTicket);
			
			return "list-Tickets";
		}
	}
}
