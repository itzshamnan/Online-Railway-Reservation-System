package com.railway.clients.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "Clients")
public class Clients {
	
	@Transient
	public static final String SEQUENCE_NAME = "userId";
	
	@Id
	private int userId;
	
	@Field
	private String name;
	@Field
	private String email;
	@Field
	private String phone_no;
	@Field
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	
	public Clients() {
		super();
	}
	public Clients(int userId, String name, String email, String phone_no, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "ClientDetails [ UserId=" + userId + ", Name=" + name + ", Email="
				+ email + ", Phone Number=" + phone_no
				+ ", Password=" + password +"]" ;
	}
	
	
	
	
	


}
