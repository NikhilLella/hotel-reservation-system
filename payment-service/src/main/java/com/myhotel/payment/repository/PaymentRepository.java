package com.myhotel.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhotel.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
