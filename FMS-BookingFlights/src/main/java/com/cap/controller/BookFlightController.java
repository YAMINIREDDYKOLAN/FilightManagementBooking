package com.cap.controller;

import java.awt.print.Book;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	// Searching for flights
	@GetMapping("/flightlist")
	public List<Flight> displayFlights() {
		return flightService.displayFlights();
	}

	@GetMapping("/book/{from_loc}/{to_loc}/{date1}")
	public String bookFlight(@PathVariable String from_loc, @PathVariable String to_loc, @PathVariable Date date1)
			throws FlightNotFound {
		List<Flight> flight1 = flightService.bookingFlights(from_loc, to_loc, date1);
		System.out.println(flight1);
		if (flight1!= null) {
			return " flights available" +flight1;
		} else
			return " no Available flights ";
	}

	// booking flight
	@GetMapping("/bookinglist")
	public List<BookingDetails> displayList() {
		return flightService.displayBookingList();
	}
	

	 @PostMapping("/addBooking") public ResponseEntity<String> addBookingDetails(@RequestBody BookingDetails booking) {
	  flightService.addBookingDetails(booking); return new
	  ResponseEntity<String>("added",HttpStatus.OK);}
	 
		
		

	// Booking information
	@GetMapping("/get/{bookingId}")
	public BookingDetails displayOneList(@PathVariable String bookingId) {
	
		return flightService.displayOneBookingList(bookingId);
	}

	
	@DeleteMapping("/cancelBooking/{bookingId}")
	  public ResponseEntity<String> deleteBookingDetails(@PathVariable BookingDetails bookingId) {
		ResponseEntity<String> response = new ResponseEntity<String>(flightService.deleteBookingDetails(bookingId),
				HttpStatus.OK);
		return response;
		
	}
	
	
	
		
	 
	
	



	@ExceptionHandler(FlightNotFound.class)
	public ResponseEntity<String> flightsNotFound(FlightNotFound e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
	}

}
