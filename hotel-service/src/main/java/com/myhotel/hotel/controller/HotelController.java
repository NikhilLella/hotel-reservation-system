package com.myhotel.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhotel.hotel.model.Hotel;
import com.myhotel.hotel.service.HotelService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hotels")
@Slf4j
public class HotelController {

	@Autowired
	private HotelService hotelService;
	private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@PostMapping("/create-hotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		log.info("inside create hotel method");
		try {
			Hotel hotel1= hotelService.saveHotel(hotel);
			return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{location}")
	public ResponseEntity<List<Hotel> >getHotelsByLocation(@PathVariable String location) {
		log.info("inside get hotels by location"+location +"das");
		List<Hotel> d = hotelService.findByLocation(location);
		log.info("the size of list is "+d.size());
		return new ResponseEntity<>(hotelService.findByLocation(location), HttpStatus.OK);
	}

}
