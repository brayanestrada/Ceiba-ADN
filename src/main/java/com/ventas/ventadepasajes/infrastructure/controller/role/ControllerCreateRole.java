package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerCreateRole;
import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class ControllerCreateRole {

    private HandlerCreateRole handlerCreateRole;

    public ControllerCreateRole(HandlerCreateRole handlerCreateRole){
        this.handlerCreateRole = handlerCreateRole;
    }

    @PostMapping("/create")
    public DtoRole createRole(@RequestBody CommandRole commandRole){
        return this.handlerCreateRole.run(commandRole);
    }
}
