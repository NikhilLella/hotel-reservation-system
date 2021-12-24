package com.myhotel.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhotel.reservation.entity.Reservation;
import com.myhotel.reservation.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> getReservationDetailsById(Integer id) {
		
		return reservationRepository.findByBookingId(id);
		
	}

}
