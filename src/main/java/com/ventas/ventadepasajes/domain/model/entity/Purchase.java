package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityPurchase;

public class Purchase {

    private long id;
    private int numberPurchasedTickets;
    private double ticketAmount;
    private int discountPercentage;
    private double totalPurchaseAmount;

    public Purchase(){}

    public Purchase(long id, int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public Purchase(int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount){
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public Purchase(long id, int numberPurchasedTickets, double ticketAmount){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
    }

    public Purchase(int numberPurchasedTickets, double ticketAmount){
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberPurchasedTickets() {
        return numberPurchasedTickets;
    }

    public void setNumberPurchasedTickets(int numberPurchasedTickets) {
        this.numberPurchasedTickets = numberPurchasedTickets;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(double ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public double getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(double totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public int getDiscountPercentage() { return discountPercentage; }

    public void setDiscountPercentage(int discountPercentage) { this.discountPercentage = discountPercentage; }

    public static Purchase valueOf(EntityPurchase entityPurchase){
        Purchase purchase = new Purchase();
        purchase.setId(entityPurchase.getId());
        purchase.setNumberPurchasedTickets(entityPurchase.getNumberPurchasedTickets());
        purchase.setTicketAmount(entityPurchase.getTicketAmount());
        purchase.setTotalPurchaseAmount(entityPurchase.getTotalPurchaseAmount());
        return purchase;
    }
}
