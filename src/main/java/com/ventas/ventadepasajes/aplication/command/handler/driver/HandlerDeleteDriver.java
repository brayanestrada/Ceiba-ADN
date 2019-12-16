package com.ventas.ventadepasajes.aplication.command.handler.driver;

import com.ventas.ventadepasajes.domain.service.driver.ServiceDeleteDriver;
import org.springframework.stereotype.Component;

@Component
public class HandlerDeleteDriver {

    private final ServiceDeleteDriver serviceDeleteDriver;

    public HandlerDeleteDriver(ServiceDeleteDriver serviceDeleteDriver){this.serviceDeleteDriver = serviceDeleteDriver;}

    public boolean run(Long id){
        return serviceDeleteDriver.run(id);
    }
}
