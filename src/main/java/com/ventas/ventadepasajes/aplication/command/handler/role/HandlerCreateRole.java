package com.ventas.ventadepasajes.aplication.command.handler.role;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryRole;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.service.role.ServiceCreateRole;
import org.springframework.stereotype.Component;

@Component
public class HandlerCreateRole {

    private final ServiceCreateRole serviceCreateDriver;
    private final FactoryRole factoryRole;

    public HandlerCreateRole(ServiceCreateRole serviceCreateDriver, FactoryRole factoryRole){
        this.serviceCreateDriver = serviceCreateDriver;
        this.factoryRole = factoryRole;
    }

    public DtoRole run(CommandRole commandRole){
        Role role = this.factoryRole.create(commandRole);
        return this.serviceCreateDriver.run(role);
    }
}
