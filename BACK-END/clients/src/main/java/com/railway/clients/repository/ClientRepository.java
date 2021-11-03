package com.railway.clients.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.railway.clients.model.Clients;


@Repository
public interface ClientRepository extends MongoRepository<Clients, String>  {

}
