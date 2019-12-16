package com.ventas.ventadepasajes.aplication.command.handler.trip;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryTrip;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import com.ventas.ventadepasajes.domain.service.trip.ServiceCreateTrip;
import org.springframework.stereotype.Component;

@Component
public class HandlerCreateTrip {

    private final FactoryTrip factoryTrip;
    private final ServiceCreateTrip serviceCreateTrip;

    public HandlerCreateTrip(FactoryTrip factoryTrip, ServiceCreateTrip serviceCreateTrip){
        this.factoryTrip = factoryTrip;
        this.serviceCreateTrip = serviceCreateTrip;
    }

    public DtoTrip run(CommandTrip commandTrip){
        return this.serviceCreateTrip.run(this.factoryTrip.create(commandTrip));
    }
}
