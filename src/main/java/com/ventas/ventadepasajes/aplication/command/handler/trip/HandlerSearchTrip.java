package com.ventas.ventadepasajes.aplication.command.handler.trip;

import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.service.trip.ServiceSearchTrip;
import org.springframework.stereotype.Component;

@Component
public class HandlerSearchTrip {

    private final ServiceSearchTrip serviceSearchTrip;

    public HandlerSearchTrip(ServiceSearchTrip serviceSearchTrip){
        this.serviceSearchTrip = serviceSearchTrip;
    }

    public Trip run(long id){
        return this.serviceSearchTrip.run(id);
    }
}
