package com.ventas.ventadepasajes.aplication.command.handler.role;

import com.ventas.ventadepasajes.domain.service.role.ServiceDeleteRole;
import org.springframework.stereotype.Component;

@Component
public class HandlerDeleteRole {

    private final ServiceDeleteRole serviceDeleteRole;

    public HandlerDeleteRole(ServiceDeleteRole serviceDeleteRole){
        this.serviceDeleteRole = serviceDeleteRole;
    }

    public boolean run(long id){ return this.serviceDeleteRole.run(id); }
}
