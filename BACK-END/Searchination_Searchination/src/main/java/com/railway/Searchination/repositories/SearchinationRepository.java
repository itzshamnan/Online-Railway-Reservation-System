package com.railway.Searchination.repositories;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.railway.Searchination.models.Train;

@Repository
public interface SearchinationRepository extends MongoRepository<Train, String>{
	@Query("{'train_no' : ?0}")
	public Train findByTrain_no(String train_no);
	
	@Query(value = "{'train_no' : ?0}", delete = true)
	public void deleteByTrain_no(String train_no);
	
	@Query("{'starting_station' : ?0,'destination' : ?1}")
	public List<Train> getTrainByStartStationandDestination(String starting_station, String destination);
}




