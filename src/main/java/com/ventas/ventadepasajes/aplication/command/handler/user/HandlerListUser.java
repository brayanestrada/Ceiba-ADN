package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.service.user.ServiceListUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListUser {
    private final ServiceListUser serviceListUser;

    public HandlerListUser(ServiceListUser serviceListUser){
        this.serviceListUser = serviceListUser;
    }

    public List<User> run(){return serviceListUser.run();}
}
