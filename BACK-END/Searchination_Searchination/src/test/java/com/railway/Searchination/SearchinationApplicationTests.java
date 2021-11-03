package com.railway.Searchination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.railway.Searchination.Service.SearchService;
import com.railway.Searchination.models.Train;
import com.railway.Searchination.repositories.SearchinationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class SearchinationApplicationTests {
	
	@Autowired
	private SearchService service;
	
	@MockBean
	private SearchinationRepository repository;
	
	@Test
	void contextLoads() {
	}
	
	
	
	//"1.Testing whether getAllDetails method is returning the records of db"
	@Test
	public void getAllDetailsTest2() 
	{
		//Added train details
		List<Train> detailsList=new ArrayList<Train>();
		Train details=new Train ("12345", "Abc Express", "Vizianagaram", "Hyderabad" , "09:00Am", "05:00Pm", "8H", "50");
		detailsList.add(details);
		//checking whether it returns correct values
		when(repository.findAll()).thenReturn(detailsList);
		List<Train> detailsListNew=service.getAllTrains();
		assertEquals(1, detailsListNew.size());
	}
	
	
	//"1.Testing getTrainDetailsByTrainNo method"
	@Test 
	public void getDetailsByTrainNoTest1() 
	{ 		
		//Added train details
		Train details=new Train("11111", "Abc Express", "Vizianagaram", 
				"Hyderabad", "09:00Am", "05:00Pm", "8H", "50");
		//Checking whether they are returning correct values or not
		when(repository.findByTrain_no("11111")).thenReturn(details);
		Train det=service.getTrainByTrain_no("11111");
		assertEquals("Abc Express",det.getArrival_time());
		assertEquals("Vizianagaram",det.getDeparture_time());
		assertEquals("Hyderabad",det.getStarting_station());
		assertEquals("09:00Am",det.getDestination());
		assertEquals("05:00Pm", det.getFare());
		assertEquals("8H", det.getJourney_time());
		assertEquals(50, det.getTotal_distance());
	}
	
	
	

}
