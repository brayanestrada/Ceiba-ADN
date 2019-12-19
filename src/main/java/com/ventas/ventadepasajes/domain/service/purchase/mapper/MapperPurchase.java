package com.ventas.ventadepasajes.domain.service.purchase.mapper;

import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;

import java.util.List;
import java.util.stream.Collectors;

public class    MapperPurchase {

    public DtoPurchase entityToDto(Purchase purchase){
        return new DtoPurchase(purchase.getId(), purchase.getNumberPurchasedTickets(), purchase.getTicketAmount(), purchase.getDiscountPercentage(), purchase.getTotalPurchaseAmount(), purchase.getIdTrip());
    }

    public List<DtoPurchase> entityListToDtoList(List<Purchase> listPurchase){
        return listPurchase.stream().map(e -> DtoPurchase.valueOf(e)).collect(Collectors.toList());
    }
}
