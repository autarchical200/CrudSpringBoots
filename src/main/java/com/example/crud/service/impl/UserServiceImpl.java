package com.example.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.entity.*;
import com.example.crud.repository.*;
import com.example.crud.service.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.example.crud.exception.*;
@Service
public class UserServiceImpl implements UserService {
@Autowired private UserRepository userRepository;

@Override
public List<User> getAllUser() {
return StreamSupport.stream(userRepository.findAll().spliterator(), false)
.collect(Collectors.toList());
}


@Override
public User saveUser(User user) {
return userRepository.save(user);
}

@Override
public User updateUser(Long id, User user) {
return userRepository.findById(id)
.map(existingUser -> {
existingUser.setName(user.getName());
existingUser.setEmail(user.getEmail());
// Cập nhật thêm các trường thông tin khác của user ở đây
return userRepository.save(existingUser);
}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
}

@Override
public void deleteUser(Long id) {
userRepository.deleteById(id);
}

@Override
public Optional<User> findUserById(Long id) {
return userRepository.findById(id);
}
}