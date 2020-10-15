package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.dto.BookingDetails;

@Repository
public interface BookFlightDao extends JpaRepository<BookingDetails, String>  {

	@Query("select f from BookingDetails f where bookingId=?1")
	BookingDetails fetch(String bookingId);

	
	

}
