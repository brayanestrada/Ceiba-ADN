package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerCreateUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class ControllerCreateUser {
    private final HandlerCreateUser handlerCreateUser;

    public ControllerCreateUser(HandlerCreateUser handlerCreateUser){
        this.handlerCreateUser = handlerCreateUser;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CommandUser commandUser){
        this.handlerCreateUser.run(commandUser);
    }
}
