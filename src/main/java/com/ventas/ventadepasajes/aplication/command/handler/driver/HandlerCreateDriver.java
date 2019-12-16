package com.ventas.ventadepasajes.aplication.command.handler.driver;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryDriver;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceCreateDriver;
import org.springframework.stereotype.Component;

@Component
public class HandlerCreateDriver {
    private final FactoryDriver factoryDriver;
    private final ServiceCreateDriver serviceCreateDriver;

    public HandlerCreateDriver(FactoryDriver factoryDriver, ServiceCreateDriver serviceCreateDriver){
        this.factoryDriver = factoryDriver;
        this.serviceCreateDriver = serviceCreateDriver;
    }

    public DtoDriver run(CommandDriver commandDriver){
        Driver driver = this.factoryDriver.create(commandDriver);
        return this.serviceCreateDriver.run(driver);
    }
}
