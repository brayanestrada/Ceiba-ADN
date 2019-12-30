package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerSearchTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
public class ControllerSearchTrip {

    private HandlerSearchTrip handlerSearchTrip;

    public ControllerSearchTrip(HandlerSearchTrip handlerSearchTrip){
        this.handlerSearchTrip = handlerSearchTrip;
    }

    @GetMapping("/search/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Trip seachTrip(@PathVariable long id){
        return this.handlerSearchTrip.run(id);
    }
}
