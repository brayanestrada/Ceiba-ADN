package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerDeleteTrip;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class ControllerDeleteTrip {

    private final HandlerDeleteTrip handlerDeleteTrip;

    public ControllerDeleteTrip(HandlerDeleteTrip handlerDeleteTrip){
        this.handlerDeleteTrip = handlerDeleteTrip;
    }

    @RequestMapping(value = "/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity deleteTrip(@PathVariable long id){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(handlerDeleteTrip.run(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
