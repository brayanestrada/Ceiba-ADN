package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerUpdateUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class ControllerUpdateUser {

    private final HandlerUpdateUser handlerUpdateUser;

    public ControllerUpdateUser(HandlerUpdateUser handlerUpdateUser){
        this.handlerUpdateUser = handlerUpdateUser;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody CommandUser commandUser, @PathVariable long id){
        return this.handlerUpdateUser.run(id, commandUser);
    }
}
