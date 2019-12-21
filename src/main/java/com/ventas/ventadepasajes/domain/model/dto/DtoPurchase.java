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
    private long idTrip;
    private String purchaseDate;
    private String tripDate;

    public DtoPurchase(){}

    public DtoPurchase(long id, int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount, long idTrip, String purchaseDate, String tripDate){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.idTrip = idTrip;
        this.purchaseDate = purchaseDate;
        this.tripDate = tripDate;
    }

    public DtoPurchase(long id, int numberPurchasedTickets, double ticketAmount, long idTrip, String purchaseDate, String tripDate){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
        this.idTrip = idTrip;
        this.purchaseDate = purchaseDate;
        this.tripDate = tripDate;
    }

    public DtoPurchase(int numberPurchasedTickets, double ticketAmount, long idTrip, String purchaseDate, String tripDate){
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
        this.idTrip = idTrip;
        this.purchaseDate = purchaseDate;
        this.tripDate = tripDate;
    }

    public static DtoPurchase valueOf(Purchase purchase){
        DtoPurchase dtoPurchase = new DtoPurchase();
        dtoPurchase.setId(purchase.getId());
        dtoPurchase.setNumberPurchasedTickets(purchase.getNumberPurchasedTickets());
        dtoPurchase.setTicketAmount(purchase.getTicketAmount());
        dtoPurchase.setDiscountPercentage(purchase.getDiscountPercentage());
        dtoPurchase.setTotalPurchaseAmount(purchase.getTotalPurchaseAmount());
        dtoPurchase.setIdTrip(purchase.getIdTrip());
        dtoPurchase.setPurchaseDate(purchase.getPurchaseDate());
        dtoPurchase.setTripDate(purchase.getTripDate());
        return dtoPurchase;
    }
}
