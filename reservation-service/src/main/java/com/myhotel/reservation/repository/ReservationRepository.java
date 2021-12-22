package com.myhotel.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhotel.reservation.model.Reservation;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List<Reservation> findByBookingId(Integer bookingId);
}
