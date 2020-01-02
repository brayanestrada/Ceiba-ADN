package com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.infrastructure.entity.EntityPurchase;

import java.util.List;
import java.util.stream.Collectors;

public class MapperPurchase {

    public List<Purchase> entityToModelList(List<EntityPurchase> entityList){
        return entityList.stream().map(MapperPurchase::valueOfModel).collect(Collectors.toList());
    }

    private static Purchase valueOfModel(EntityPurchase entityPurchase){
        return new Purchase(entityPurchase.getIdEntity(),
                entityPurchase.getNumberPurchasedTicketsEntity(),
                entityPurchase.getTicketAmountEntity(),
                entityPurchase.getDiscountPercentageEntity(),
                entityPurchase.getTotalPurchaseAmountEntity(),
                entityPurchase.getIdTripEntity(),
                entityPurchase.getPurchaseDateEntity(),
                entityPurchase.getTripDateEntity()
        );
    }

    public EntityPurchase modelToEntity(Purchase purchase){
        return new EntityPurchase(purchase.getId(),
                purchase.getNumberPurchasedTickets(),
                purchase.getTicketAmount(),
                purchase.getDiscountPercentage(),
                purchase.getTotalPurchaseAmount(),
                purchase.getIdTrip(),
                purchase.getPurchaseDate(),
                purchase.getTripDate());
    }

}
