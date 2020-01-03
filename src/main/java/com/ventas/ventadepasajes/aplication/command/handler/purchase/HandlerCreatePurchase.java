package com.ventas.ventadepasajes.aplication.command.handler.purchase;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceCreatePurchase;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class HandlerCreatePurchase {

    private final FactoryPurchase factoryPurchase;
    private final ServiceCreatePurchase serviceCreatePurchase;

    public HandlerCreatePurchase(FactoryPurchase factoryPurchase, ServiceCreatePurchase serviceCreatePurchase){
        this.factoryPurchase = factoryPurchase;
        this.serviceCreatePurchase = serviceCreatePurchase;
    }

    public Purchase run(CommandPurchase commandPurchase) throws ParseException {
        return this.serviceCreatePurchase.run(this.factoryPurchase.create(commandPurchase));
    }
}
