package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class FactoryTrip {

    public Trip create(CommandTrip commandTrip){
        return new Trip(commandTrip.getSeatsAvailable(), commandTrip.getSeatsSold(), commandTrip.getStartCity(), commandTrip.getEndCity(), commandTrip.getIdDriver(), commandTrip.getTripDate(), commandTrip.getTicketAmount());
    }

    public Trip update(long id, CommandTrip commandTrip){
        return new Trip(id, commandTrip.getSeatsAvailable(), commandTrip.getSeatsSold(), commandTrip.getStartCity(), commandTrip.getEndCity(), commandTrip.getIdDriver(), commandTrip.getTripDate(), commandTrip.getTicketAmount());
    }
}
