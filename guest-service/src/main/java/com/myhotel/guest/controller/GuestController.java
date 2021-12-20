package com.myhotel.guest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhotel.guest.model.Guest;
import com.myhotel.guest.service.GuestService;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/guests")
@Slf4j
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	private static final Logger log = LoggerFactory.getLogger(GuestController.class);

	@PostMapping("/create-guest")
	public ResponseEntity<Guest> createGuest (@RequestBody Guest guest ){
	log.info("the id of the guest is +" + guest.getId());	
		guestService.createGuest(guest);
		try {
		return new ResponseEntity<Guest>(guest,HttpStatus.CREATED);
	}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
