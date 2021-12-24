package com.myhotel.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="payment_details")
public class Payment {

	@Id
	@Column(name="payment_id")
	private Long paymentId;
	
	@Column(name="guest_id")
	private Integer guestId;
	
	@Column(name="hotel_id")
	private Integer hotelId;
	
	@Column(name="room_id")
	private Integer roomId;
	
}
