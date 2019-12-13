package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;
import com.ventas.ventadepasajes.domain.model.entity.Destination;
import org.springframework.stereotype.Component;

@Component
public class FactoryDestination {
    public FactoryDestination(){}

    public Destination create(CommandDestination commandDestination){
        return new Destination(commandDestination.getName());
    }
}
