package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerCreateTrip;
import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class ControllerCreateTrip {

    private HandlerCreateTrip handlerCreateTrip;

    public ControllerCreateTrip(HandlerCreateTrip handlerCreateTrip){
        this.handlerCreateTrip = handlerCreateTrip;
    }

    @CrossOrigin
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public DtoTrip createTrip(@RequestBody CommandTrip commandTrip){
        return this.handlerCreateTrip.run(commandTrip);
    }
}
