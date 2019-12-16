package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class FactoryRole {

    public FactoryRole(){}

    public Role create(CommandRole commandRole){
        return new Role(commandRole.getName());
    }

    public Role update(long id, CommandRole commandRole){
        return new Role(id, commandRole.getName());
    }
}
