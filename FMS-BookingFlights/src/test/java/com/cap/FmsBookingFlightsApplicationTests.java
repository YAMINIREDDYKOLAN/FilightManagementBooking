package com.cap;


import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cap.dto.BookingDetails;
import com.cap.service.BookFlightService;

@SpringBootTest
class FmsBookingFlightsApplicationTests {

	@Autowired
	private BookFlightService service;
	
	@Test
	public void Booking()  {
		
		BookingDetails book=new BookingDetails("15", 100, 100, "yamini");
		BookingDetails book1=new BookingDetails();
		//Optional<BookingDetails> book1;
		book1=service.displayOneBookingList("15");
		
		
				
		//Assertions.assertEquals(book.toString(),book1.toString());
		//Assertions.assertEquals(book1.getPassengerName(),"yamini");
		Assertions.assertEquals(book.getUserId(),book1.getUserId());
		

	}
	
	
	 

}



