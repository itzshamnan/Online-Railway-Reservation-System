package com.railway.booking.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.railway.booking.Model.TicketDetails;


@Repository
public interface BookingRepository extends MongoRepository<TicketDetails, String> {
	
	@Query("{'email' : ?0}")
	public List<TicketDetails> getTicketsbyEmail(String email);
	
	@Query("{'ticket_sequence' : ?0}")
	public TicketDetails findByTicket_no(int ticket_sequence);
	
	@Query(value = "{'ticket_sequence' : ?0}", delete = true)
	public void deleteTicket(int ticket_sequence);

}
