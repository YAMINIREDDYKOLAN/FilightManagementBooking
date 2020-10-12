package com.cap.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cap.dto.BookingDetails;
import com.cap.dto.Flight;
import com.cap.service.BookFlightService;

import com.exception.FlightNotFound;

@RestController
@RequestMapping("/Flights")
@CrossOrigin("http://localhost:4200")
public class BookFlightController {

	@Autowired
	BookFlightService flightService;
    //Searching for flights
	@GetMapping("/flightlist")
	public List<Flight> displayFlights() {
		return flightService.displayFlights();
	}

	
	  @GetMapping("/book/{from_loc}/{to_loc}/{date1}") 
     public String bookFlight(@PathVariable String from_loc, @PathVariable String to_loc, @PathVariable Date date1) throws FlightNotFound  { 
	List<Flight> flight1 = flightService.bookingFlights(from_loc, to_loc,date1); 
	
	if (flight1 != null) {
		
	  
	  return "Available flights " + flight1;
			  } 
	else
	return "no flights available"; }
	
	 
	  //booking flight
	 @GetMapping("/bookinglist") 
	 public List<BookingDetails> displayList() {
	 return flightService.displayBookingList(); }

	@PostMapping("/addBooking")
	public ResponseEntity<String> addBookingDetails(@RequestBody BookingDetails booking) {
		ResponseEntity<String> response =  new ResponseEntity<String>(flightService.addBookingDetails(booking),HttpStatus.OK);
		return response ;
	}
    //Booking information
	@GetMapping("/get/{bookingId}")
	public BookingDetails displayOneList(@PathVariable String bookingId) {
		return flightService.displayOneBookingList(bookingId);
	}
	
	
	  @ExceptionHandler(FlightNotFound.class) public ResponseEntity<String>
	  flightsNotFound(FlightNotFound e) {
	  return new ResponseEntity<>(e.getMessage(), HttpStatus.OK); }
	 
	  
}