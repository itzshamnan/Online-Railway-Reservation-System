package com.railway.booking.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.booking.Model.TicketDetails;
import com.railway.booking.Repository.BookingRepository;
import com.railway.booking.Service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingRepository repo;
	

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/findAllTickets")
	public List<TicketDetails> getAllTickets() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/findAllTickets/{email}")
	public List<TicketDetails> getTicketsbyEmail() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/ticket/add")
	public String addUserDetails(@RequestBody TicketDetails ticketDetails)
	{
		ticketDetails.setTicket_sequence(bookingService.getNextSequence(ticketDetails.SEQUENCE_NAME));


	    return bookingService.addTicketBookingDetails(ticketDetails);	
    }
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/delete/{ticket_sequence}")
	public List<TicketDetails> deleteTicket(@PathVariable int ticket_sequence) {
		repo.deleteTicket(ticket_sequence);
		return repo.findAll();	
		}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/findTicket/{ticket_sequence}")
	public TicketDetails findByTicket_no(@PathVariable int ticket_sequence) {
		return repo.findByTicket_no(ticket_sequence);
	}


}
