package com.myhotel.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhotel.guest.entity.Guest;

public interface GuestRepository  extends JpaRepository<Guest, Integer>{

}
