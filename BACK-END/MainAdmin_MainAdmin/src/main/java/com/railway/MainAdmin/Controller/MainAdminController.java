package com.railway.MainAdmin.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.MainAdmin.Service.MainAdminService;
import com.railway.MainAdmin.models.Train;

@RestController
@RequestMapping("/Admin")
public class MainAdminController {
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}
	
	@Autowired
	private MainAdminService repo;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addTrain")
	public List<Train> saveTrain(@RequestBody Train train) {
		repo.addTrain(train);
		return repo.getAllTrain();	}
	
	@GetMapping("/findAllTrain")
	public List<Train> getTrains(){
		return repo.getAllTrain();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/findAllTrain/{id}")
	public Optional<Train> getTrain(@PathVariable String id){
		return repo.getTrainbyTrain_no(id);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public List<Train> deleteTrain(@PathVariable String id) {
		repo.deleteTrain(id);
		return repo.getAllTrain();	
		}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/update/{id}")
	public List<Train> updateTrain (@PathVariable String id,@RequestBody Train train) {
		repo.updateTrain(id, train);
		return repo.getAllTrain();

	}

	


}
