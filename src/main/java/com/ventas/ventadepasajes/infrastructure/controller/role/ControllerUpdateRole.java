package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerUpdateRole;
import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class ControllerUpdateRole {

    private HandlerUpdateRole handlerUpdateRole;

    public ControllerUpdateRole(HandlerUpdateRole handlerUpdateRole){
        this.handlerUpdateRole = handlerUpdateRole;
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public DtoRole updateRole(@RequestBody CommandRole commandRole, @PathVariable long id){
        return this.handlerUpdateRole.run(id, commandRole);
    }
}
