package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.infrastructure.entity.EntityPurchase;

public class Purchase {

    private long id;
    private int numberPurchasedTickets;
    private double ticketAmount;
    private int discountPercentage;
    private double totalPurchaseAmount;
    private long idTrip;

    public Purchase(){}

    public Purchase(long id, int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount, long idTrip){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.idTrip = idTrip;
    }

    public Purchase(int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount, long idTrip){
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.idTrip = idTrip;
    }

    public Purchase(long id, int numberPurchasedTickets, double ticketAmount, long idTrip){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
        this.idTrip = idTrip;
    }

    public Purchase(int numberPurchasedTickets, double ticketAmount, long idTrip){
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
        this.idTrip = idTrip;
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

    public long getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(long idTrip) {
        this.idTrip = idTrip;
    }

    public static Purchase valueOf(EntityPurchase entityPurchase){
        Purchase purchase = new Purchase();
        purchase.setId(entityPurchase.getId());
        purchase.setNumberPurchasedTickets(entityPurchase.getNumberPurchasedTickets());
        purchase.setTicketAmount(entityPurchase.getTicketAmount());
        purchase.setTotalPurchaseAmount(entityPurchase.getTotalPurchaseAmount());
        purchase.setIdTrip(entityPurchase.getIdTrip());
        return purchase;
    }
}
