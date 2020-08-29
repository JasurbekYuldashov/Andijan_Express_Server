package com.example.demo.models.dao;

import com.example.demo.models.Product;
import com.example.demo.models.Users;
import com.example.demo.repository.LikeProductsRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDtoService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final LikeProductsRepository likeProductsRepository;

    public UserDtoService(UserRepository userRepository, ProductRepository productRepository, LikeProductsRepository likeProductsRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.likeProductsRepository = likeProductsRepository;
    }
}
