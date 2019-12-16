package com.ventas.ventadepasajes.aplication.command.handler.purchase;

import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.ServiceListPurchase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListPurchase {

    private final ServiceListPurchase serviceListPurchase;

    public HandlerListPurchase(ServiceListPurchase serviceListPurchase){this.serviceListPurchase = serviceListPurchase;}

    public List<DtoPurchase> run(){return serviceListPurchase.run();}
}
