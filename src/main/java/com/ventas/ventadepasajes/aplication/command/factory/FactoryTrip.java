package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class FactoryTrip {

    public FactoryTrip(){}

    public Trip create(CommandTrip commandTrip){
        return new Trip(commandTrip.getCost(), commandTrip.getSeats_available(), commandTrip.getSeats_sold(), commandTrip.getStartCity(), commandTrip.getEndCity(), commandTrip.getIdDriver());
    }

    public Trip update(long id, CommandTrip commandTrip){
        return new Trip(id, commandTrip.getCost(), commandTrip.getSeats_available(), commandTrip.getSeats_sold(), commandTrip.getStartCity(), commandTrip.getEndCity(), commandTrip.getIdDriver());
    }
}
