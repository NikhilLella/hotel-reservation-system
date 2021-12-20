package com.myhotel.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhotel.guest.model.Guest;
import com.myhotel.guest.repository.GuestRepository;


@Service
public class GuestService {
	
	@Autowired
	private GuestRepository guestRepository;
	

	public Guest createGuest(Guest guest) {
		return  guestRepository.save(guest);
		
	}

}
