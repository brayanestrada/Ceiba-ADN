package com.ventas.ventadepasajes.aplication.command.handler.purchase;

import com.ventas.ventadepasajes.aplication.command.factory.FactoryPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceUpdatePurchase;
import org.springframework.stereotype.Component;

@Component
public class HandlerUpdatePurchase {

    private final FactoryPurchase factoryPurchase;
    private final ServiceUpdatePurchase serviceUpdatePurchase;

    public HandlerUpdatePurchase(FactoryPurchase factoryPurchase, ServiceUpdatePurchase serviceUpdatePurchase){
        this.factoryPurchase = factoryPurchase;
        this.serviceUpdatePurchase = serviceUpdatePurchase;
    }

    public DtoPurchase run(long id, CommandPurchase commandPurchase){
        return this.serviceUpdatePurchase.run(id, this.factoryPurchase.update(id, commandPurchase));
    }
}
