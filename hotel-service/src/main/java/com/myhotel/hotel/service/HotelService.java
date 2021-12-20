package com.myhotel.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhotel.hotel.model.Hotel;
import com.myhotel.hotel.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public List<Hotel> findByLocation(String location) {
		return hotelRepository.findByLocation(location);
		
	}

}
