package com.myhotel.guest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhotel.guest.entity.Guest;
import com.myhotel.guest.model.GuestResponse;
import com.myhotel.guest.service.GuestService;

import brave.sampler.Sampler;

@RestController
@RequestMapping("/guests")

public class GuestController {

	@Autowired
	private GuestService guestService;

	@Bean
	private Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	private static final Logger log = LoggerFactory.getLogger(GuestController.class);

	@PostMapping("/guest")
	public ResponseEntity<GuestResponse> createGuest(@RequestBody Guest guest) {
		log.info("the id of the guest is +" + guest.getId());

		try {

			return new ResponseEntity<GuestResponse>(guestService.createGuest(guest), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<GuestResponse> findByGuestId(@PathVariable Integer id) {
		log.info("inside find by guest id method");
		try {
			GuestResponse g = guestService.findByGuestId(id);

			return new ResponseEntity<GuestResponse>(guestService.findByGuestId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
