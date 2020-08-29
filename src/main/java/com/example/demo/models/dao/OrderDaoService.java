package com.example.demo.models.dao;


import com.example.demo.models.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDaoService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public OrderDaoService( OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<OrderDao> get(){
        List<Order> orders=orderRepository.findAllByDeletedFalse();
        List<OrderDao> orderDaos = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            OrderDao orderDao = new OrderDao();
            orderDao.setOrder(orders.get(i));
            orderDao.setUser(userRepository.findAllByDeletedFalseAndId(orders.get(i).getUserId()));
            orderDao.setProduct(productRepository.findAllByDeletedFalseAndId(orders.get(i).getProductId()));
            orderDaos.add(orderDao);
        }

        return orderDaos;
    }


    public List<OrderDao> getByUserId(Integer id) {
        List<Order> orders=orderRepository.findAllByDeletedFalseAndUserId(id);
        List<OrderDao> orderDaos = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            OrderDao orderDao = new OrderDao();
            orderDao.setOrder(orders.get(i));
            orderDao.setUser(userRepository.findAllByDeletedFalseAndId(orders.get(i).getUserId()));
            orderDao.setProduct(productRepository.findAllByDeletedFalseAndId(orders.get(i).getProductId()));
            orderDaos.add(orderDao);
        }

        return orderDaos;
    }
}
