package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerLogIn;
import com.ventas.ventadepasajes.domain.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class ControllerLogIn {

    private HandlerLogIn handlerLogIn;

    public ControllerLogIn(HandlerLogIn handlerLogIn){
        this.handlerLogIn = handlerLogIn;
    }

    @CrossOrigin
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public User logIn(@RequestBody CommandUser commandUser){
        return this.handlerLogIn.run(commandUser.getEmail(), commandUser.getPassword());
    }
}
