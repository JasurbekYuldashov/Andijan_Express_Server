package com.example.demo.repository;

import com.example.demo.models.LikeProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeProductsRepository extends JpaRepository<LikeProducts,Integer> {
    List<LikeProducts> findAllByDeletedFalseAndUserId(Integer id);
}
