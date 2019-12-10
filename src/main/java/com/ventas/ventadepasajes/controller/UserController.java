package com.ventas.ventadepasajes.controller;

import com.ventas.ventadepasajes.dto.UserDto;
import com.ventas.ventadepasajes.entity.User;
import com.ventas.ventadepasajes.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> findUsers(){
        return userService.findAll();
    }

    @PostMapping("/add_user")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
