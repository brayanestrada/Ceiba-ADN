package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.factory.FactoryUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import com.ventas.ventadepasajes.domain.service.user.ServiceCreateUser;
import org.springframework.stereotype.Component;

@Component
public class HandlerCreateUser {
    private final ServiceCreateUser serviceCreateUser;
    private final FactoryUser factoryUser;

    public HandlerCreateUser(ServiceCreateUser serviceCreateClient, FactoryUser factoryUser){
        this.serviceCreateUser = serviceCreateClient;
        this.factoryUser = factoryUser;
    }

    public User run(CommandUser commandUser){
        User user = this.factoryUser.create(commandUser);
        return this.serviceCreateUser.run(user);
    }
}
