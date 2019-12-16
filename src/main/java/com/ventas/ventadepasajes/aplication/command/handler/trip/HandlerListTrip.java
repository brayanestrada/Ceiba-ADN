package com.ventas.ventadepasajes.aplication.command.handler.trip;

import com.ventas.ventadepasajes.domain.model.dto.DtoTrip;
import com.ventas.ventadepasajes.domain.service.trip.ServiceListTrip;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListTrip {

    private final ServiceListTrip serviceListTrip;

    public HandlerListTrip(ServiceListTrip serviceListTrip){ this.serviceListTrip = serviceListTrip;}

    public List<DtoTrip> run(){return serviceListTrip.run();}
}
