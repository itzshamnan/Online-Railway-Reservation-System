package com.railway.booking.Service;

import java.util.List;




import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.railway.booking.Model.DatabaseSequence;
import com.railway.booking.Model.TicketDetails;
import com.railway.booking.Repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingrepo;
	
	public List<TicketDetails> getAllTickets() {
		return bookingrepo.findAll();
	}
	
	public TicketDetails findByTicket_no(int ticket_sequence) {
		return bookingrepo.findByTicket_no(ticket_sequence);
	}
	
	public List<TicketDetails> getTicketsbyEmail(String email) {
		return bookingrepo.getTicketsbyEmail(email);
	}

	
	@DeleteMapping("/delete/{ticket_sequence}")
	public List<TicketDetails> deleteTicket(int ticket_sequence) {
		bookingrepo.deleteTicket(ticket_sequence);
		return bookingrepo.findAll();
	}

	
	private BookingService(MongoOperations db) {
		this.database=db;
	}

	@Autowired
	private static MongoOperations database;

	

	public String addTicketBookingDetails(TicketDetails ticketDetails) {
		bookingrepo.save(ticketDetails);	
		return ("Your ticket booked successfully...!!!  "
				+ "Your PNR number is "+ ticketDetails.getTicket_sequence() + " Please proceed to payment....");
	}
	
	
	public static int getNextSequence(String key)  {
		  DatabaseSequence dbSeq=database.findAndModify(query(where("ticket_sequence").is(key)), 
				  new Update().inc("sequence",1), options().returnNew(true).upsert(true),
				  DatabaseSequence.class); 
		  return !Objects.isNull(dbSeq) ? dbSeq.getSequence() : 1;
		  } 
	
	

}
