package com.example.demo.rest;

import com.example.demo.binding.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/usuarios/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }


}
