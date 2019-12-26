package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerSearchRole;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class ControllerSearchRole {

    private HandlerSearchRole handlerSearchRole;

    public ControllerSearchRole(HandlerSearchRole handlerSearchRole){ this.handlerSearchRole = handlerSearchRole; }

    @CrossOrigin
    @GetMapping("/search/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void searchRole(@PathVariable long id){
        this.handlerSearchRole.run(id);
    }
}
