package com.example.demo.repository;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByDeletedFalse();

    List<Product> findAllByCategoryId(Integer id);
    List<Product> findAllByDescriptionLike(String string);
    List<Product> findAllByDeletedFalseAndCategoryIdAndCategoryTypeId(Integer id,Integer cId);

    Product findAllByDeletedFalseAndId(Integer id);
    Product findByDeletedFalseAndId(Integer id);
}
