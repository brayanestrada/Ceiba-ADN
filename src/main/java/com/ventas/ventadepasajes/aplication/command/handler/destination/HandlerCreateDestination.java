package com.ventas.ventadepasajes.aplication.command.handler.destination;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryDestination;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;
import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.model.entity.Destination;
import com.ventas.ventadepasajes.domain.service.destination.ServiceCreateDestination;
import org.springframework.stereotype.Component;

@Component
public class HandlerCreateDestination {
    private final FactoryDestination factoryDestination;
    private final ServiceCreateDestination serviceCreateDestination;

    public HandlerCreateDestination(ServiceCreateDestination serviceCreateDestination, FactoryDestination factoryDestination){
        this.serviceCreateDestination = serviceCreateDestination;
        this.factoryDestination = factoryDestination;
    }

    public DtoDestination run(CommandDestination commandDestination){
        Destination destination = this.factoryDestination.create(commandDestination);
        return this.serviceCreateDestination.run(destination);
    }
}
