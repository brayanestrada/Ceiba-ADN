package com.ventas.ventadepasajes.infrastructure.controller;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerCreateUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ControllerUser {
    private final HandlerCreateUser handlerCreateUser;

    public ControllerUser(HandlerCreateUser handlerCreateUser){
        this.handlerCreateUser = handlerCreateUser;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody CommandUser commandUser){
        return this.handlerCreateUser.run(commandUser);
    }
}
