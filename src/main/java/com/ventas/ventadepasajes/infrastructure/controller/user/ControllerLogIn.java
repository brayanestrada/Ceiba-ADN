package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerLogIn;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.model.entity.dto.UserDto;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class ControllerLogIn {

    private HandlerLogIn handlerLogIn;

    public ControllerLogIn(HandlerLogIn handlerLogIn){
        this.handlerLogIn = handlerLogIn;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public UserDto logIn(@RequestBody CommandUser commandUser){
        MapperUser mapperUser = new MapperUser();
        User user = this.handlerLogIn.run(commandUser.getEmail(), commandUser.getPassword());
        return mapperUser.modelToDto(user);
    }
}
