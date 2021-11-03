package com.railway.clients.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.MongoOperations;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.railway.clients.model.Clients;
import com.railway.clients.model.DatabaseSequence;
import com.railway.clients.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepo;
	
	private ClientService(MongoOperations db) {
		this.database=db;
	}
	@Autowired
	private static MongoOperations database;
	
	
	public static int getNextSequence(String key)  {
		DatabaseSequence dbSeq=database.findAndModify(query(where("userId").is(key)), 
				  new Update().inc("sequence",1), options().returnNew(true).upsert(true),
				  DatabaseSequence.class); 
		  return !Objects.isNull(dbSeq) ? dbSeq.getSequence() : 1;
		  } 
	
	public String addClients(Clients client) {
		clientRepo.save(client);	
		return ("Sign Up successfull...!!!  "
				+ "Your userId is "+ client.getUserId() + " Please proceed to payment....");
	}

}
