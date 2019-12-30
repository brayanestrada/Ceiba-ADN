package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerListUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class ControllerListUser {

    private final HandlerListUser handlerListUser;

    public ControllerListUser(HandlerListUser handlerListUser){
        this.handlerListUser = handlerListUser;
    }

    @GetMapping("/list")
    public List<User> listUser(){
        return this.handlerListUser.run();
    }
}
