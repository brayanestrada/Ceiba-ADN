package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.service.user.ServiceLogIn;
import org.springframework.stereotype.Component;

@Component
public class HandlerLogIn {

    private final ServiceLogIn serviceLogIn;

    public HandlerLogIn(ServiceLogIn serviceLogIn){
        this.serviceLogIn = serviceLogIn;
    }

    public User run(String email, String password){
        return this.serviceLogIn.run(email, password);
    }
}
