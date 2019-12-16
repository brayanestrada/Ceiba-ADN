package com.ventas.ventadepasajes.aplication.command.handler.trip;

import com.ventas.ventadepasajes.domain.service.trip.ServiceDeleteTrip;
import org.springframework.stereotype.Component;

@Component
public class HandlerDeleteTrip {

    private final ServiceDeleteTrip serviceDeleteTrip;

    public HandlerDeleteTrip(ServiceDeleteTrip serviceDeleteTrip){
        this.serviceDeleteTrip = serviceDeleteTrip;
    }

    public boolean run(long id){return this.serviceDeleteTrip.run(id);}
}
