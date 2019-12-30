package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerDeleteTrip;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
public class ControllerDeleteTrip {

    private final HandlerDeleteTrip handlerDeleteTrip;

    public ControllerDeleteTrip(HandlerDeleteTrip handlerDeleteTrip){
        this.handlerDeleteTrip = handlerDeleteTrip;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteTrip(@PathVariable long id){
        if(handlerDeleteTrip.run(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
