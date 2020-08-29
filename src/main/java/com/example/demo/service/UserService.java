package com.example.demo.service;


import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> get(){
        return userRepository.findAllByDeletedFalse() ;
    }

    public Users getOne(Integer id){
        return userRepository.findAllByDeletedFalseAndId(id) ;
    }


    public Integer geet(){
        return userRepository.countAllByDeletedFalse();
    }

    public void save(Users user){
//        List<Users> usersList = get();
//        Integer g=0;
//        for (int i = 0; i < usersList.size(); i++) {
//            if (user.getId()==usersList.get(i).getId()){
//                usersList.get(i).setUsername(user.getUsername());
//                usersList.get(i).setFirstName(user.getFirstName());
//                usersList.get(i).setLastName(user.getLastName());
//                usersList.get(i).setLocation(user.getLocation());
//                usersList.get(i).setCashBack(user.getCashBack());
//                userRepository.save(usersList)
//                break;
//            } else {
//                g++;
//            }
//        }
//        if (g==usersList.size()){
//
//        }
        userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }





}
