package com.railway.clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.railway.clients.model.Clients;
import com.railway.clients.repository.ClientRepository;
import com.railway.clients.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/")
	public String hello(){
		return "hello" ;
	}
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepository clientRepo;
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/signup")
	public String signup(@RequestBody Clients client) {
		
		client.setUserId(clientService.getNextSequence(client.SEQUENCE_NAME));
	    return clientService.addClients(client);	

		}

}
