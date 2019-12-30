package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerCreateTrip;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
public class ControllerCreateTrip {

    private HandlerCreateTrip handlerCreateTrip;

    public ControllerCreateTrip(HandlerCreateTrip handlerCreateTrip){
        this.handlerCreateTrip = handlerCreateTrip;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrip(@RequestBody CommandTrip commandTrip){
        this.handlerCreateTrip.run(commandTrip);
    }
}
