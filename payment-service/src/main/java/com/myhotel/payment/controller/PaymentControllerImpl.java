package com.myhotel.payment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentControllerImpl  implements PaymentController{

	@PostMapping ("/")
	public void completePayment() {
		
	}
}
