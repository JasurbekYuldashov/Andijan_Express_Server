package com.example.demo.repository;

import com.example.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByDeletedFalse();
    List<Order> findAllByDeletedFalseAndUserId(Integer id);
}
