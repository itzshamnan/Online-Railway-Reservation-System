package com.railway.MainAdmin.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.railway.MainAdmin.models.Train;
import com.railway.MainAdmin.repositories.MainAdminRepository;

@Service
public class MainAdminService {
	@Autowired
	private MainAdminRepository repo;
	
	public List<Train> addTrain (Train train) {
		repo.save(train);
		return repo.findAll();

	}
	public List<Train> getAllTrain(){
		return repo.findAll();
	}
	
	public Optional<Train> getTrainbyTrain_no(String train_no){
		return repo.findById(train_no);
	}
	@DeleteMapping("/delete/{id}")
	public List<Train> deleteTrain(String id) {
		repo.deleteById(id);
		return repo.findAll();
	}
	
	public Train updateTrain(String id,Train train) {
		Train Details= repo.findById(id).orElseThrow();{
			Details.setTrain_no(train.getTrain_no());
			Details.setArrival_time(train.getArrival_time());
			Details.setDeparture_time(train.getDeparture_time());
			Details.setStarting_station(train.getStarting_station());
			Details.setDestination(train.getDestination());
			Details.setFare(train.getFare());
			Details.setJourney_time(train.getJourney_time());
			Details.setTotal_distance(train.getTotal_distance());
			return repo.save(Details);
		}
	}

}
