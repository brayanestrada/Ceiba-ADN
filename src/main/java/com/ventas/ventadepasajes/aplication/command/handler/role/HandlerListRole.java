package com.ventas.ventadepasajes.aplication.command.handler.role;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.service.role.ServiceListRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListRole {

    private final ServiceListRole serviceListRole;

    public HandlerListRole(ServiceListRole serviceListRole){
        this.serviceListRole = serviceListRole;
    }

    public List<Role> run(){return this.serviceListRole.run();}
}
