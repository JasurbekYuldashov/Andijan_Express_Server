package com.example.demo.repository;

import com.example.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByDeletedFalse();

    void deleteById(Integer id);
}
