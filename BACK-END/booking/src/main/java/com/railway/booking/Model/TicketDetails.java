package com.railway.booking.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "Tickets")
public class TicketDetails {

	
	@Transient
	public static final String SEQUENCE_NAME = "ticket_sequence";

	@Id
	private int ticket_sequence;

	
	@Field
	private String name;
	@Field
	private String email;
	@Field
	private String address;
	@Field
	private String phone_no;
	@Field
	private String train_no;
	@Field
	private String starting_station;
	@Field
	private String destination;
	@Field
	private String date;
	

	public TicketDetails() {
		super();
	}
	

	

	public String getStarting_station() {
		return starting_station;
	}




	public void setStarting_station(String starting_station) {
		this.starting_station = starting_station;
	}




	public String getDestination() {
		return destination;
	}




	public void setDestination(String destination) {
		this.destination = destination;
	}








	public TicketDetails(int ticket_sequence, String name, String email, String address, String phone_no,
			String train_no, String starting_station, String destination, String date) {
		super();
		this.ticket_sequence = ticket_sequence;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone_no = phone_no;
		this.train_no = train_no;
		this.starting_station = starting_station;
		this.destination = destination;
		this.date = date;
	}




	public int getTicket_sequence() {
		return ticket_sequence;
	}




	public void setTicket_sequence(int ticket_sequence) {
		this.ticket_sequence = ticket_sequence;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getPhone_no() {
		return phone_no;
	}




	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}




	public String getTrain_no() {
		return train_no;
	}




	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}




	@Override
	public String toString() {
		return "TicketDetails [ PNR Number=" + ticket_sequence + ", Name=" + name + ", Email="
				+ email + ", Address=" + address + ", Phone Number=" + phone_no
				+ ", Train No=" + train_no +" Starting Station=" + starting_station
						+ ", Destination=" + destination +", Date=" + date + "]";
	}


}
