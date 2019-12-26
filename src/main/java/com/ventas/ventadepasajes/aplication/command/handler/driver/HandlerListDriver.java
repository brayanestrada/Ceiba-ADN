package com.ventas.ventadepasajes.aplication.command.handler.driver;

import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceListDriver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListDriver {

    private final ServiceListDriver serviceListDriver;

    public HandlerListDriver(ServiceListDriver serviceListDriver) {
        this.serviceListDriver = serviceListDriver;
    }

    public List<Driver> run(){return serviceListDriver.run();}
}
