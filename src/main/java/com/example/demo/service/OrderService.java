package com.example.demo.service;


import com.example.demo.models.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> get(){
        return orderRepository.findAllByDeletedFalse();
    }
    public List<Order> getByUserId(Integer id){
        return orderRepository.findAllByDeletedFalseAndUserId(id);
    }

    public Optional<Order> getById(Integer id){
        return orderRepository.findById(id);
    }

    public void save(Order order){
        orderRepository.save(order);
    }

    public void delete(Integer id){
        orderRepository.deleteById(id);
    }

}
