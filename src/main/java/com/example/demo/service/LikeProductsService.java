package com.example.demo.service;


import com.example.demo.models.LikeProducts;
import com.example.demo.repository.LikeProductsRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeProductsService {
    private final LikeProductsRepository likeProductsRepository;

    public LikeProductsService(LikeProductsRepository likeProductsRepository, ProductRepository productRepository) {
        this.likeProductsRepository = likeProductsRepository;
    }

    public List<LikeProducts> getAll(Integer id) {
        List<LikeProducts> likeProducts = likeProductsRepository.findAllByDeletedFalseAndUserId(id);
        return likeProducts;
    }

    public void save(LikeProducts likeProducts) {
        likeProductsRepository.save(likeProducts);
    }

    public void delete(Integer id) {
        likeProductsRepository.deleteById(id);
    }
}
