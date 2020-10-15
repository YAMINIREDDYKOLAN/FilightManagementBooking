package com.cap.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;

import com.cap.dto.BookingDetails;
import com.cap.dto.Flight;


public interface BookFlightService {
	@Transactional
	public List<Flight> displayFlights();
	public  List<Flight> bookingFlights(String from_loc,String to_loc,Date date1);
	//public BookingDetails addBookingDetails(BookingDetails booking);
	public String addBookingDetails(BookingDetails booking);
	public BookingDetails displayOneBookingList(String bookingId);
	public List<BookingDetails> displayBookingList();
	 public String deleteBookingDetails(BookingDetails bookingId) ;
	
	

		
	
	
	
	
}
