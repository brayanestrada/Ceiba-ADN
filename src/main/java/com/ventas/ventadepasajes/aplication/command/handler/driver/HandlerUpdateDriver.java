package com.ventas.ventadepasajes.aplication.command.handler.driver;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryDriver;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import com.ventas.ventadepasajes.domain.service.driver.ServiceUpdateDriver;
import org.springframework.stereotype.Component;

@Component
public class HandlerUpdateDriver {
    private final FactoryDriver factoryDriver;
    private final ServiceUpdateDriver serviceUpdateDriver;

    public HandlerUpdateDriver(FactoryDriver factoryDriver, ServiceUpdateDriver serviceUpdateDriver){
        this.factoryDriver = factoryDriver;
        this.serviceUpdateDriver = serviceUpdateDriver;
    }

    public DtoDriver run(Long id, CommandDriver commandDriver){
        Driver driver = this.factoryDriver.update(id, commandDriver);
        return this.serviceUpdateDriver.run(id, driver);
    }
}
