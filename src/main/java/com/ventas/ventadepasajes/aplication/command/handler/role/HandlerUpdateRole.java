package com.ventas.ventadepasajes.aplication.command.handler.role;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryRole;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.service.role.ServiceUpdateRole;
import org.springframework.stereotype.Component;

@Component
public class HandlerUpdateRole {

    private final FactoryRole factoryRole;
    private final ServiceUpdateRole serviceUpdateRole;

    public HandlerUpdateRole(FactoryRole factoryRole, ServiceUpdateRole serviceUpdateRole){
        this.factoryRole = factoryRole;
        this.serviceUpdateRole = serviceUpdateRole;
    }

    public DtoRole run(long id, CommandRole commandRole){
        return this.serviceUpdateRole.run(id, this.factoryRole.update(id, commandRole));
    }
}
