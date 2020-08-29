package com.example.demo.controller;

import com.example.demo.models.Order;
import com.example.demo.models.dao.OrderDao;
import com.example.demo.models.dao.OrderDaoService;
import com.example.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;
    private final OrderDaoService orderDaoService;

    public OrderController(OrderService orderService, OrderDaoService orderDaoService) {
        this.orderService = orderService;
        this.orderDaoService = orderDaoService;
    }

    @GetMapping("/get")
    public ResponseEntity get(){
        List<OrderDao> orderList = orderDaoService.get();
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/get/user/{id}")
    public ResponseEntity getByUserId(@PathVariable Integer id){
        List<OrderDao> orderList = orderDaoService.getByUserId(id);
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        Optional<Order> orderList = orderService.getById(id);
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/d/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        orderService.delete(id);
        return ResponseEntity.ok("ok");
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Order order){
        orderService.save(order);
        return ResponseEntity.ok("ok");
    }
}
