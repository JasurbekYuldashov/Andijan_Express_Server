package com.example.demo.controller;

import com.example.demo.models.Payment;
import com.example.demo.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/get")
    public ResponseEntity get(){
        List<Payment> payments = paymentService.getAll();
        return ResponseEntity.ok(payments);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Payment payment){
        paymentService.save(payment);
        List<Payment> payments = paymentService.getAll();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("d/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        paymentService.delete(id);
        List<Payment> payments = paymentService.getAll();
        return ResponseEntity.ok(payments);
    }
}
