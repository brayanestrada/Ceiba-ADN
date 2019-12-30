package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerUpdateRole;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class ControllerUpdateRole {

    private HandlerUpdateRole handlerUpdateRole;

    public ControllerUpdateRole(HandlerUpdateRole handlerUpdateRole){
        this.handlerUpdateRole = handlerUpdateRole;
    }
    @PutMapping("/update/{id}")
    public void updateRole(@RequestBody CommandRole commandRole, @PathVariable long id){
        this.handlerUpdateRole.run(id, commandRole);
    }
}
