package com.unittest.controller;

import com.unittest.model.Users;
import com.unittest.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class Resource {


    @Autowired
    UsersRepository usersRepository;

    /*public Resource(UsersRepository usersRepository){
        this.usersRepository =usersRepository;
    }*/

    @GetMapping("/")
    public List<Users> all() {
        return usersRepository.findAll();
    }

}