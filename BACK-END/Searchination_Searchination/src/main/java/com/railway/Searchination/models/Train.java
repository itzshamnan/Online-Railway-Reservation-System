package com.railway.Searchination.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="TrainDetails")
public class Train {
	@Id
	private String id;
	@Field
	private String train_no;
	@Field
	private String arrival_time;
	@Field
	private String departure_time;
	@Field
	private String starting_station;
	@Field
	private String destination;
	@Field
	private String fare;
	@Field
	private String journey_time;
	@Field
	private String total_distance;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTrain_no() {
		return train_no;
	}
	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
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
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getJourney_time() {
		return journey_time;
	}
	public void setJourney_time(String journey_time) {
		this.journey_time = journey_time;
	}
	
	public String getTotal_distance() {
		return total_distance;
	}
	public void setTotal_distance(String total_distance) {
		this.total_distance = total_distance;
	}
	
	
	public Train(String train_no, String arrival_time, String departure_time, String starting_station,
			String destination, String fare, String journey_time,  String total_distance) {
		super();
		this.train_no = train_no;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.starting_station = starting_station;
		this.destination = destination;
		this.fare = fare;
		this.journey_time = journey_time;
		this.total_distance = total_distance;
	}
	public Train() {
		
	}

	@Override
	public String toString() {
		return "Train [train_no=" + train_no + ", arrival_time=" + arrival_time + ", departure_time="
				+ departure_time + ", starting_station=" + starting_station + ", destination=" + destination
				+ ", fare=" + fare + ", journey_time=" + journey_time + ", total_distance=" + total_distance + "]";
		}
		
		


}
