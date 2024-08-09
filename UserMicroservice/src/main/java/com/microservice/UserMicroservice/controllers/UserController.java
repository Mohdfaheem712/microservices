package com.microservice.UserMicroservice.controllers;

import com.microservice.UserMicroservice.entities.User;
import com.microservice.UserMicroservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user){
        User data = userService.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User data = userService.getUserById(userId);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> data = userService.getAll();
        return ResponseEntity.ok(data);
    }
}
