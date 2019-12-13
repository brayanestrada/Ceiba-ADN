package com.ventas.ventadepasajes.infrastructure.controller.destination;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;
import com.ventas.ventadepasajes.aplication.command.handler.destination.HandlerCreateDestination;
import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/destination")
public class ControllerCreateDestination {

    private HandlerCreateDestination handlerCreateDestination;

    public ControllerCreateDestination(HandlerCreateDestination handlerCreateDestination){
        this.handlerCreateDestination = handlerCreateDestination;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DtoDestination createDestination(@RequestBody CommandDestination commandDestination){
        return this.handlerCreateDestination.run(commandDestination);
    }
}
