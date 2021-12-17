package com.myhotel.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhotel.hotel.model.Hotel;
import com.myhotel.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/{date}")
	public Hotel findAvailableHotels(@PathVariable("date") final String date) {
		hotelService.findAvailableHotels(date);
		return null;
	}
	
	
}
