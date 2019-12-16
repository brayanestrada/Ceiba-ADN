package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryUser;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.domain.model.dto.DtoUser;
import com.ventas.ventadepasajes.domain.service.user.ServiceUpdateUser;
import org.springframework.stereotype.Component;

@Component
public class HandlerUpdateUser {

    private final FactoryUser factoryUser;
    private final ServiceUpdateUser serviceUpdateUser;

    public HandlerUpdateUser(FactoryUser factoryUser, ServiceUpdateUser serviceUpdateUser){
        this.factoryUser = factoryUser;
        this.serviceUpdateUser = serviceUpdateUser;
    }

    public DtoUser run(long id, CommandUser commandUser){
        return this.serviceUpdateUser.run(id, this.factoryUser.update(id, commandUser));
    }
}
