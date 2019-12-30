package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerUpdateTrip;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
public class ControllerUpdateTrip {

    private HandlerUpdateTrip handlerUpdateTrip;

    public ControllerUpdateTrip(HandlerUpdateTrip handlerUpdateTrip){
        this.handlerUpdateTrip = handlerUpdateTrip;
    }

    @PutMapping("/update/{id}")
    public void updateTrip(@RequestBody CommandTrip commandTrip, @PathVariable long id){
        this.handlerUpdateTrip.run(id, commandTrip);
    }
}
