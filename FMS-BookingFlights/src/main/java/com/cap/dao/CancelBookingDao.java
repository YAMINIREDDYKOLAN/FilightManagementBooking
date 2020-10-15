package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.dto.BookingDetails;

public interface CancelBookingDao extends JpaRepository<BookingDetails, String>{

	

}
