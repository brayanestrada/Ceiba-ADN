package com.ventas.ventadepasajes.aplication.command.handler.role;

import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import com.ventas.ventadepasajes.domain.service.role.ServiceListRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListRole {

    private final ServiceListRole serviceListRole;

    public HandlerListRole(ServiceListRole serviceListRole){
        this.serviceListRole = serviceListRole;
    }

    public List<DtoRole> run(){return this.serviceListRole.run();}
}
