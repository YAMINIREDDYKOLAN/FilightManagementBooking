package com.cap.service;

import java.sql.Date;
import java.util.List;

import com.cap.dto.BookingDetails;
import com.cap.dto.Flight;


public interface BookFlightService {
	public List<Flight> displayFlights();
	public  List<Flight> bookingFlights(String from_loc,String to_loc,Date date1);
	public String addBookingDetails(BookingDetails booking);
	public BookingDetails displayOneBookingList(String bookingId);
	public List<BookingDetails> displayBookingList();
	
}
