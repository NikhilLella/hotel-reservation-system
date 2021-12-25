package com.myhotel.guest.service;

import javax.validation.Valid;

import com.myhotel.guest.model.GuestDTO;

public interface GuestService {
	void addGuest(GuestDTO dto);
	GuestDTO findByGuestId (Integer guestId);
	void deleteGuest(Integer guestId);
	void updateGuest(@Valid GuestDTO body);
	
	GuestDTO updateGuestbyId(Integer guestId, String name, String proof, String stayHistory, String address,
			Long mobileNumber);
	
	
}
