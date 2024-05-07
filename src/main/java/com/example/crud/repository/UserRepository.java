package com.example.crud.repository;

import org.springframework.data.repository.CrudRepository;  
import org.springframework.stereotype.Repository;  
import com.example.crud.entity.*;

@Repository  
public interface UserRepository extends CrudRepository<User, Long> {}
