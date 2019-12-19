package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerUpdateTrip;
import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class ControllerUpdateTrip {

    private HandlerUpdateTrip handlerUpdateTrip;

    public ControllerUpdateTrip(HandlerUpdateTrip handlerUpdateTrip){
        this.handlerUpdateTrip = handlerUpdateTrip;
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public DtoTrip updateTrip(@RequestBody CommandTrip commandTrip, @PathVariable long id){
        return this.handlerUpdateTrip.run(id, commandTrip);
    }
}
