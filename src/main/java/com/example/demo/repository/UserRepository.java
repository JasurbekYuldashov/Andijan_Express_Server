package com.example.demo.repository;

import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {
    void deleteById(Integer id);
    List<Users> findAllByDeletedFalse();

    Integer countAllByDeletedFalse();

    Users findAllByDeletedFalseAndId(Integer id);
}
