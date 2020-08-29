package com.example.demo.repository;


import com.example.demo.models.CategorySecond;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorySecondRepository extends JpaRepository<CategorySecond,Integer> {

    public List<CategorySecond> findAllByDeletedFalse();
}
