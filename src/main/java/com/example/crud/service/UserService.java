package com.example.crud.service;

import com.example.crud.entity.*;

import java.util.List;  
import java.util.Optional;  

public interface UserService {  
  List<User> getAllUser();  

  void saveUser(User user);  

  void deleteUser(Long id);  

  Optional<User> findUserById(Long id);  
}