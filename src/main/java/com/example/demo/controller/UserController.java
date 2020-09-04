package com.example.demo.controller;


import com.example.demo.models.Users;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        List<Users> usersList = userService.get();
        return new ResponseEntity(usersList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        Users usersList = userService.getOne(id);
        return new ResponseEntity(usersList, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity dd() {
        return ResponseEntity.ok(userService.geet());
    }

    @GetMapping("/d/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        userService.delete(id);
        List<Users> usersList = userService.get();
        return ResponseEntity.ok(usersList);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Users user) {
        userService.save(user);
        List<Users> usersList = userService.get();
        return ResponseEntity.ok(user.getId());
    }
}
