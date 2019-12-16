package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.service.purchase.mapper.MapperPurchase;

public class ServiceUpdatePurchase {

    private RepositoryPurchase repositoryPurchase;

    public ServiceUpdatePurchase(RepositoryPurchase repositoryPurchase){
        this.repositoryPurchase = repositoryPurchase;
    }

    public DtoPurchase run(long id, Purchase newPurchase){
        MapperPurchase mapper = new MapperPurchase();
        double totalWithoutDiscount = newPurchase.getNumberPurchasedTickets() * newPurchase.getTicketAmount();
        if(newPurchase.getNumberPurchasedTickets()>4){
            newPurchase.setDiscountPercentage(10);
            double discountAmount = totalWithoutDiscount*(newPurchase.getDiscountPercentage())/100;
            newPurchase.setTotalPurchaseAmount(totalWithoutDiscount-discountAmount);
        }else{
            newPurchase.setDiscountPercentage(0);
            newPurchase.setTotalPurchaseAmount(totalWithoutDiscount);
        }
        return mapper.entityToDto(this.repositoryPurchase.updatePurchase(id, newPurchase));
    }
}
