package com.myhotel.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhotel.hotel.model.Hotel;
import com.myhotel.hotel.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	public Hotel findAvailableHotels(String date) {
	return null;
		
	}

}
