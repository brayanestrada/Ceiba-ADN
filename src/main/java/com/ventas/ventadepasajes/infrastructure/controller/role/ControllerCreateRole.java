package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerCreateRole;
import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class ControllerCreateRole {

    private HandlerCreateRole handlerCreateRole;

    public ControllerCreateRole(HandlerCreateRole handlerCreateRole){
        this.handlerCreateRole = handlerCreateRole;
    }

    @CrossOrigin
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DtoRole createRole(@RequestBody CommandRole commandRole){
        return this.handlerCreateRole.run(commandRole);
    }
}
