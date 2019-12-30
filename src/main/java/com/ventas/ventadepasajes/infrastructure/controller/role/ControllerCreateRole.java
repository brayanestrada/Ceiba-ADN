package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerCreateRole;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class ControllerCreateRole {

    private HandlerCreateRole handlerCreateRole;

    public ControllerCreateRole(HandlerCreateRole handlerCreateRole){
        this.handlerCreateRole = handlerCreateRole;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody CommandRole commandRole) { this.handlerCreateRole.run(commandRole);
    }
}
