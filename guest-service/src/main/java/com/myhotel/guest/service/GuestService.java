package com.myhotel.guest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhotel.guest.entity.Guest;
import com.myhotel.guest.model.GuestResponse;
import com.myhotel.guest.repository.GuestRepository;


@Service
public class GuestService {
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private GuestResponse guestResponse;

	public GuestResponse createGuest(Guest guest) {
		GuestResponse gr = findByGuestId(guest.getId());
		if(!gr.getIsPresent().booleanValue()) {
		guestResponse.clearGuestResponse();
		guestResponse.setGuest(guestRepository.save(guest));
		guestResponse.setResponseMessage("success");
		}
		return  guestResponse;
		
		
	}


	public GuestResponse findByGuestId(Integer id) {
		guestResponse.clearGuestResponse();
		
		Optional<Guest> og = guestRepository.findById(id);
		
		if(og.isPresent()) {
			guestResponse.setGuest(og.get());
			guestResponse.setIsPresent(true);
			guestResponse.setResponseMessage("guest already exists with id "+id);
		}
		else 
			guestResponse.setResponseMessage("cannot find the guest with the id "+id);
		return guestResponse;
	}

}
