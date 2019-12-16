package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.service.user.ServiceListUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListUser {
    private final ServiceListUser serviceListUser;

    public HandlerListUser(ServiceListUser serviceListUser){
        this.serviceListUser = serviceListUser;
    }

    public List<DtoUser> run(){return serviceListUser.run();}
}
