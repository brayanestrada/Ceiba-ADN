package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.service.user.ServiceLogIn;
import org.springframework.stereotype.Component;

@Component
public class HandlerLogIn {

    private final ServiceLogIn serviceLogIn;

    public HandlerLogIn(ServiceLogIn serviceLogIn){
        this.serviceLogIn = serviceLogIn;
    }

    public DtoUser run(String email, String password){
        return this.serviceLogIn.run(email, password);
    }
}
