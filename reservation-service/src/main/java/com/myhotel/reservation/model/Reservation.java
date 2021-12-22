package com.myhotel.reservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="reservation_details")
@Data
public class Reservation {
	@Id
	@Column(name="booking_id")
	private Integer bookingId;
	
	@Column(name="guest_id")
	private Integer guestId;
	
	@Column(name="hotel_id")
	private Integer hotelId;
	
	@Column(name="room_no")
	private Integer roomNo;
	
	@Column(name="room_type")
	private String roomType;
	
	@Column(name="check_in")
	private Date checkIn;
	
	@Column(name="check_out")
	private Date checkOut;
	
	@Column(name="total_price")
	private Long totalPrice;
	
}
