package com.example.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddemo.model.User;
import com.example.cruddemo.repository.UserRepository;

@Service
public class UserServie {
 
    @Autowired
    private  UserRepository userRepository;


    public List<User> alluserslist(){
        return  userRepository.findAll();
    }

    public User adduser(User user){
        return userRepository.save(user);
    }

    public boolean   deleteuser(String id){
        if(userRepository.existsById(id)){
             userRepository.deleteById(id);
         return true;

        }else{
            return false;
        }
    }

public User getuserbyid(String id){

    Optional<User> user = userRepository.findById(id);
    return user.orElse(null);

}

    //update the user by user id 

    public boolean updateuser(String id,User updateduser){
        Optional<User> existinguser=userRepository.findById(id);

        if(existinguser.isPresent()){
            User user=existinguser.get();

            user.setName(updateduser.getName());
            user.setEmail(updateduser.getEmail());

            userRepository.save(user);
            return true;
        }else{
            return false;
        }

    }







}
