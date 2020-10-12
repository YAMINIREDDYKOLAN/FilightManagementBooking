package com.cap.dto;

import java.io.Serializable;

/*@author                                             kolan yamini
Description                                         it is entity class for bookinglist   
version                                              1.0
Created Date                                        05-10-20
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "bookinglist")
@SequenceGenerator(name="seq", initialValue=100, allocationSize=3)
public class BookingDetails implements Serializable{
	@Id
	@Column(length = 5)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private String bookingId;
	@Column(length = 5)
	private int userId;
	@Column(length = 5)
	private int noofSeats;
	@Column(length = 10)
	private String passengerName;
	
	
	public BookingDetails(String bookingId, int userId, int noofSeats, String passengerName) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.noofSeats = noofSeats;
		this.passengerName = passengerName;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoofSeats() {
		return noofSeats;
	}
	public void setNoofSeats(int noofSeats) {
		this.noofSeats = noofSeats;
	}


	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public BookingDetails() {
		super();
	}

	
	
}

