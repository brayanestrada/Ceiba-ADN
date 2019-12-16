package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerUpdateUser;
import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ControllerUpdateUser {

    private final HandlerUpdateUser handlerUpdateUser;

    public ControllerUpdateUser(HandlerUpdateUser handlerUpdateUser){
        this.handlerUpdateUser = handlerUpdateUser;
    }

    @PutMapping("/update/{id}")
    public DtoUser updateUser(@RequestBody CommandUser commandUser, @PathVariable long id){
        return this.handlerUpdateUser.run(id, commandUser);
    }
}
