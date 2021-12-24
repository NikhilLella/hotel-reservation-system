package com.myhotel.reservation.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

	private Integer bookingId;
	private Integer guestId;
	private Integer hotelId;
	private Integer roomNo;
	private String roomType;
	private Date checkIn;
	private Date checkOut;
	private Long totalPrice;
	
}
