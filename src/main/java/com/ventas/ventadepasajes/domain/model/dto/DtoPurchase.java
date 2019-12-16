package com.ventas.ventadepasajes.domain.model.dto;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPurchase {

    private long id;
    private int numberPurchasedTickets;
    private double ticketAmount;
    private int discountPercentage;
    private double totalPurchaseAmount;

    public DtoPurchase(){}

    public DtoPurchase(long id, int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public DtoPurchase(long id, int numberPurchasedTickets, double ticketAmount){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
    }

    public DtoPurchase(int numberPurchasedTickets, double ticketAmount){
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
    }

    public static DtoPurchase valueOf(Purchase purchase){
        DtoPurchase dtoPurchase = new DtoPurchase();
        dtoPurchase.setId(purchase.getId());
        dtoPurchase.setNumberPurchasedTickets(purchase.getNumberPurchasedTickets());
        dtoPurchase.setTicketAmount(purchase.getTicketAmount());
        dtoPurchase.setDiscountPercentage(purchase.getDiscountPercentage());
        dtoPurchase.setTotalPurchaseAmount(purchase.getTotalPurchaseAmount());
        return dtoPurchase;
    }
}
