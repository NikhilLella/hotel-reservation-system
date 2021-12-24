package com.myhotel.guest.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myhotel.guest.entity.Guest;

import lombok.Data;

@Data
@Component
public class GuestResponse {

	private Guest guest;
	
	private List<Guest> guests;
	
	private Boolean isPresent;
	
	private String responseMessage;
	
	public void clearGuestResponse() {
		this.guest=null;
		this.guests=null;
		this.isPresent=null;
		this.responseMessage=null;
	}
}
