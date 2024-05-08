package com.example.crud.controller;

import com.example.crud.service.*;
import com.example.crud.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired private UserService userService;

@GetMapping("/")
public List<User> getAllUsers() {
return userService.getAllUser();
}

@PostMapping("/")
public User addUser(@RequestBody User user) {
return userService.saveUser(user);
}

@GetMapping("/{id}")
public User getUserById(@PathVariable Long id) {
return userService.findUserById(id).orElse(null);
}

@PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
return userService.updateUser(id, user);
}

@DeleteMapping("/{id}")
public void deleteUser(@PathVariable Long id) {
userService.deleteUser(id);
}
}
