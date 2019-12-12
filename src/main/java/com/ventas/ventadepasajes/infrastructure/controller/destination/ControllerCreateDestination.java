package com.ventas.ventadepasajes.infrastructure.controller;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;
import com.ventas.ventadepasajes.aplication.command.handler.destination.HandlerCreateDestination;
import com.ventas.ventadepasajes.aplication.command.handler.destination.HandlerListDestination;
import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class ControllerDestination {

    private HandlerCreateDestination handlerCreateDestination;
    private HandlerListDestination handlerListDestination;

    public ControllerDestination(HandlerCreateDestination handlerCreateDestination){
        this.handlerCreateDestination = handlerCreateDestination;
    }

    public ControllerDestination(HandlerListDestination handlerListDestination){
        this.handlerListDestination = handlerListDestination;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DtoDestination createDestination(@RequestBody CommandDestination commandDestination){
        return this.handlerCreateDestination.run(commandDestination);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<DtoDestination> listDestination(){
        return this.handlerListDestination.run();
    }
}
