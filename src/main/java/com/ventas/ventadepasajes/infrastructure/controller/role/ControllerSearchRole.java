package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerSearchRole;
import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class ControllerSearchRole {

    private HandlerSearchRole handlerSearchRole;

    public ControllerSearchRole(HandlerSearchRole handlerSearchRole){ this.handlerSearchRole = handlerSearchRole; }

    @CrossOrigin
    @GetMapping("/search/{id}")
    public DtoRole searchRole(@PathVariable long id){
        return this.handlerSearchRole.run(id);
    }
}
