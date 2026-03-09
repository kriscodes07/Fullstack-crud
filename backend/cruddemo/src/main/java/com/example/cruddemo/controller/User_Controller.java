package com.example.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.model.User;
import com.example.cruddemo.service.UserServie;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class User_Controller {
    
@Autowired
UserServie uservicServie;


@GetMapping()
public List<User> getusers(){
    return uservicServie.alluserslist();
}


@PostMapping()
public User postMethodName(@RequestBody User user) {
    //TODO: process POST request
    
    return uservicServie.adduser(user);
}

@DeleteMapping("/{id}")
public String delteuser(@PathVariable String id){
    if(uservicServie.deleteuser(id)){
        return ("Deleted successfully ");
    }
        
   return ("Unablt to delte");
    
}

@PutMapping("/updateuser/{id}")
public String updateuser(@PathVariable String id,@RequestBody User user){

if(uservicServie.updateuser(id, user)){
    return "updatedsuccessfully";
}
return "Unable to updade sorry";

}


@GetMapping("/userbyid/{id}")
public User getMethodName(@PathVariable String id) {
    return uservicServie.getuserbyid(id);
}


}





