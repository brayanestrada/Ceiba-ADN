package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.domain.service.user.ServiceDeleteUser;
import org.springframework.stereotype.Component;

@Component
public class HandlerDeleteUser {

    private final ServiceDeleteUser serviceDeleteUser;

    public HandlerDeleteUser(ServiceDeleteUser serviceDeleteUser){
        this.serviceDeleteUser = serviceDeleteUser;
    }

    public boolean run(long id){return this.serviceDeleteUser.run(id);}
}
