package com.myhotel.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhotel.guest.model.Guest;

public interface GuestRepository  extends JpaRepository<Guest, Integer>{

}
