package com.example.demo.service;


import com.example.demo.models.Payment;
import com.example.demo.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAll() {
        List<Payment> payments = paymentRepository.findAllByDeletedFalse();
        return payments;
    }

    public void save(Payment payment){
        paymentRepository.save(payment);
    }

    public void delete(Integer id){
        paymentRepository.deleteById(id);
    }
}
