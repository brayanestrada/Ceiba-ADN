package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.mapper.MapperPurchase;

public class ServiceCreatePurchase {

    private RepositoryPurchase repositoryPurchase;

    public ServiceCreatePurchase(RepositoryPurchase repositoryPurchase){this.repositoryPurchase = repositoryPurchase;}

    public DtoPurchase run(Purchase purchase){
        MapperPurchase mapperPurchase = new MapperPurchase();
        double totalWithoutDiscount = purchase.getNumberPurchasedTickets() * purchase.getTicketAmount();
        if(purchase.getNumberPurchasedTickets()>4){
            purchase.setDiscountPercentage(10);
            double discountAmount = totalWithoutDiscount*(purchase.getDiscountPercentage())/100;
            purchase.setTotalPurchaseAmount(totalWithoutDiscount-discountAmount);
        }else{
            purchase.setDiscountPercentage(0);
            purchase.setTotalPurchaseAmount(totalWithoutDiscount);
        }
        return mapperPurchase.entityToDto(this.repositoryPurchase.createPurchase(purchase));
    }
}
