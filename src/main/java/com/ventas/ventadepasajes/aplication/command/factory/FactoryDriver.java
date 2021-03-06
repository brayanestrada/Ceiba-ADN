package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.domain.model.entity.Driver;
import org.springframework.stereotype.Component;

@Component
public class FactoryDriver {

    public Driver create(CommandDriver commandDriver){
        return new Driver(commandDriver.getName(), commandDriver.getLastName(), commandDriver.getIdentification());
    }

    public Driver update(long id, CommandDriver commandDriver){
        return new Driver(id, commandDriver.getName(), commandDriver.getLastName(), commandDriver.getIdentification());
    }
}
