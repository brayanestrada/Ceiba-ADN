package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.ventas.ventadepasajes.aplication.command.handler.trip.HandlerListTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class ControllerListTrips {

    private HandlerListTrip handlerListTrip;

    public ControllerListTrips(HandlerListTrip handlerListTrip){
        this.handlerListTrip = handlerListTrip;
    }

    @GetMapping("/list")
    public List<Trip> listTrip(){
        return this.handlerListTrip.run();
    }
}
