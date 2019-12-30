package com.ventas.ventadepasajes.aplication.command.handler.trip;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryTrip;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
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

    public Trip run(CommandTrip commandTrip){

        if(!this.serviceCreateTrip.driverExists(commandTrip.getIdDriver())){
            throw new ExceptionGeneral("Error: There are no drivers with id = " + commandTrip.getIdDriver());
        }else{
            return this.serviceCreateTrip.run(this.factoryTrip.create(commandTrip));
        }
    }
}
