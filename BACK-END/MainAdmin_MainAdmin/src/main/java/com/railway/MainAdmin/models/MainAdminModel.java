package com.railway.MainAdmin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="TrainAuthority")
public class MainAdminModel {
	@Id
	private String id;
	@Field
	private int User_ID;
	@Field
	private String User_Name;
	@Field
	private String Email;
	@Field
	private String Password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int User_ID) {
		this.User_ID = User_ID;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String User_Name) {
		this.User_Name = User_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}

}
