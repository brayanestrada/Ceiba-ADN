package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.infrastructure.entity.EntityPurchase;

import java.util.List;
import java.util.stream.Collectors;

public class MapperPurchase {

    public List<Purchase> entityToModelList(List<EntityPurchase> entityList){
        return entityList.stream().map(e -> valueOfModel(e)).collect(Collectors.toList());
    }

    public static Purchase valueOfModel(EntityPurchase entityPurchase){
        Purchase purchase = new Purchase();
        purchase.setTotalPurchaseAmount(entityPurchase.getTotalPurchaseAmount());
        purchase.setId(entityPurchase.getId());
        purchase.setNumberPurchasedTickets(entityPurchase.getNumberPurchasedTickets());
        purchase.setPurchaseDate(entityPurchase.getPurchaseDate());
        purchase.setDiscountPercentage(entityPurchase.getDiscountPercentage());
        purchase.setPurchaseDate(entityPurchase.getPurchaseDate());
        purchase.setIdTrip(entityPurchase.getIdTrip());
        purchase.setTripDate(entityPurchase.getTripDate());
        purchase.setTicketAmount(entityPurchase.getTicketAmount());
        return purchase;
    }

}
