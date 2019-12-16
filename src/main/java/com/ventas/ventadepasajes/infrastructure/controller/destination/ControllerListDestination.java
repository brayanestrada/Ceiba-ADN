package com.ventas.ventadepasajes.infrastructure.controller.destination;

import com.ventas.ventadepasajes.aplication.command.handler.destination.HandlerListDestination;
import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/destination")
public class ControllerListDestination {
    private final HandlerListDestination handlerListDestination;

    public ControllerListDestination(HandlerListDestination handlerListDestination){
        this.handlerListDestination = handlerListDestination;
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<DtoDestination> listDestination(){
        return this.handlerListDestination.run();
    }
}
