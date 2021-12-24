package com.myhotel.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhotel.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	List<Hotel> findByLocation(String location);

}
