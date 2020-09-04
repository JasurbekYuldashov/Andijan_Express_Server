package com.example.demo.service;


import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> get() {
        return userRepository.findAllByDeletedFalse();
    }

    public Users getOne(Integer id) {
        return userRepository.findAllByDeletedFalseAndId(id);
    }


    public Integer geet() {
        return userRepository.countAllByDeletedFalse();
    }

    public void save(Users user) {
        Users newUser = userRepository.findByUsername(user.getUsername());
        if (newUser != null) {
            System.out.println(newUser.getUsername());
        } else {
            userRepository.save(user);
        }
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }


}
