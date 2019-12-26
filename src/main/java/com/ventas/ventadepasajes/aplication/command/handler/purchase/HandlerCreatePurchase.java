package com.ventas.ventadepasajes.aplication.command.handler.purchase;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.domain.exceptions.ExceptionParsing;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceCreatePurchase;
import org.springframework.stereotype.Component;

@Component
public class HandlerCreatePurchase {

    private final FactoryPurchase factoryPurchase;
    private final ServiceCreatePurchase serviceCreatePurchase;

    public HandlerCreatePurchase(FactoryPurchase factoryPurchase, ServiceCreatePurchase serviceCreatePurchase){
        this.factoryPurchase = factoryPurchase;
        this.serviceCreatePurchase = serviceCreatePurchase;
    }

    public Purchase run(CommandPurchase commandPurchase) throws ExceptionParsing {
        return this.serviceCreatePurchase.run(this.factoryPurchase.create(commandPurchase));
    }
}
