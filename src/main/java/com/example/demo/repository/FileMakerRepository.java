package com.example.demo.repository;

import com.example.demo.models.FileMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMakerRepository extends JpaRepository<FileMaker,Integer> {
    FileMaker findByDeletedFalseAndId(Integer id);
}
