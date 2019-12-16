package com.ventas.ventadepasajes.aplication.command.handler.destination;

import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.service.destination.ServiceListDestination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListDestination {
    private final ServiceListDestination serviceListDestination;

    public HandlerListDestination(ServiceListDestination serviceListDestination){
        this.serviceListDestination = serviceListDestination;
    }

    public List<DtoDestination> run(){
        return serviceListDestination.run();
    }
}
