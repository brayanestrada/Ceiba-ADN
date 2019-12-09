package com.ventas.ventadepasajes.controller;

import com.ventas.ventadepasajes.entity.User;
import com.ventas.ventadepasajes.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUserService userService;

    @GetMapping("/users")
    public String findUsers(){
        return "Testing successful Brayan";
    }
}
