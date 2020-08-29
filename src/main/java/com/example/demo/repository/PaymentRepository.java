package com.example.demo.repository;

import com.example.demo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findAllByDeletedFalse();
}
