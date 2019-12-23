package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerCreateUser;
import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ControllerCreateUser {
    private final HandlerCreateUser handlerCreateUser;

    public ControllerCreateUser(HandlerCreateUser handlerCreateUser){
        this.handlerCreateUser = handlerCreateUser;
    }

    @CrossOrigin
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public DtoUser createUser(@RequestBody CommandUser commandUser){
        return this.handlerCreateUser.run(commandUser);
    }
}