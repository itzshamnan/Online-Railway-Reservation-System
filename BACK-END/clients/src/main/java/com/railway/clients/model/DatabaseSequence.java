package com.railway.clients.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DatabaseSequence")
public class DatabaseSequence {

	
	@Transient
	public static final String SEQUENCE_NAME = "userId";

	@Id
	private String id;
	private int sequence;

	public DatabaseSequence() {
		super();
	}

	public DatabaseSequence(int sequence) {
		super();
		this.sequence = sequence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "DatabaseSequence [id=" + id + ", sequence=" + sequence + "]";
	}
}
