package com.ventas.ventadepasajes.aplication.command.handler.purchase;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceListPurchase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListPurchase {

    private final ServiceListPurchase serviceListPurchase;

    public HandlerListPurchase(ServiceListPurchase serviceListPurchase){this.serviceListPurchase = serviceListPurchase;}

    public List<Purchase> run(){return serviceListPurchase.run();}
}
