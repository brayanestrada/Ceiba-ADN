package com.ventas.ventadepasajes.aplication.command.handler.role;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.service.role.ServiceSearchRole;
import org.springframework.stereotype.Component;

@Component
public class HandlerSearchRole {

    private final ServiceSearchRole serviceSearchRole;

    public HandlerSearchRole(ServiceSearchRole serviceSearchRole){ this.serviceSearchRole = serviceSearchRole; }

    public Role run(long id){
        return this.serviceSearchRole.run(id);
    }
}
