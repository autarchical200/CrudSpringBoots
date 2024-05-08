
package com.example.crud.service;

import com.example.crud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
List<User> getAllUser();

User saveUser(User user);

User updateUser(Long id, User user);

void deleteUser(Long id);

Optional<User> findUserById(Long id);
}