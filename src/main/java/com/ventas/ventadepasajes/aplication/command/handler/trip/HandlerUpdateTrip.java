package com.ventas.ventadepasajes.aplication.command.handler.trip;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryTrip;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.service.trip.ServiceUpdateTrip;
import org.springframework.stereotype.Component;

@Component
public class HandlerUpdateTrip {

    private final FactoryTrip factoryTrip;
    private final ServiceUpdateTrip serviceUpdateTrip;

    public HandlerUpdateTrip(FactoryTrip factoryTrip, ServiceUpdateTrip serviceUpdateTrip){
        this.factoryTrip = factoryTrip;
        this.serviceUpdateTrip = serviceUpdateTrip;
    }

    public Trip run(long id, CommandTrip commandTrip){
        return this.serviceUpdateTrip.run(id, this.factoryTrip.update(id, commandTrip));
    }
}
