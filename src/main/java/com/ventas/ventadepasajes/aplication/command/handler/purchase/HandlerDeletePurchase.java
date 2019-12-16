package com.ventas.ventadepasajes.aplication.command.handler.purchase;

import com.ventas.ventadepasajes.domain.service.purchase.ServiceDeletePurchase;
import org.springframework.stereotype.Component;

@Component
public class HandlerDeletePurchase {

    private final ServiceDeletePurchase serviceDeletePurchase;

    public HandlerDeletePurchase(ServiceDeletePurchase serviceDeletePurchase){
        this.serviceDeletePurchase = serviceDeletePurchase;
    }

    public boolean run(long id){return this.serviceDeletePurchase.run(id);}
}
