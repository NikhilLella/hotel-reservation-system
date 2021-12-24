package com.myhotel.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

	private Long paymentId;
	private Integer guestId;
	private Integer hotelId;
	private Integer roomId;
	
}
