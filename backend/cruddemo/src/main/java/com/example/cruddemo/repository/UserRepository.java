package com.example.cruddemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
