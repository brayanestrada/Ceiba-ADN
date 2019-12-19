package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.ventas.ventadepasajes.aplication.command.handler.role.HandlerListRole;
import com.ventas.ventadepasajes.domain.model.dto.DtoRole;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class ControllerListRole {

    private HandlerListRole handlerListRole;

    public ControllerListRole(HandlerListRole handlerListRole){
        this.handlerListRole = handlerListRole;
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<DtoRole> listRole(){
        return this.handlerListRole.run();
    }
}
