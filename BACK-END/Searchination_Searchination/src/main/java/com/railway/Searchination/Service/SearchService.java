package com.railway.Searchination.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.railway.Searchination.models.Train;
import com.railway.Searchination.repositories.SearchinationRepository;
@Service
public class SearchService {
	@Autowired
	private SearchinationRepository searchrepo;
	
	public List<Train> getAllTrains() {
		return searchrepo.findAll();
	}

	public Train getTrainByTrain_no(String train_no) {
		return searchrepo.findByTrain_no(train_no);
	}

	public List<Train> getTrainByStartStationandDestination(String starting_station, String destination) {
		List<Train> detList = searchrepo.findAll();
		List<Train> req = new ArrayList<Train>();
		for (Train tr : detList) {
			String starting=tr.getStarting_station();
			String final_station=tr.getDestination();
			if(starting.equals(starting_station) && final_station.equals(final_station))
				req.add(tr);
			}
		return req;
	}
	
	
}
