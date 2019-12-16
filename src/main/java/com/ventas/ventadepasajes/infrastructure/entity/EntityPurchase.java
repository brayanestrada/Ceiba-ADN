package com.ventas.ventadepasajes.infrastructure.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_purchase")
public class EntityPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private int numberPurchasedTickets;
    private double ticketAmount;
    private int discountPercentage;
    private double totalPurchaseAmount;

    public EntityPurchase(){}

    public EntityPurchase(long id, int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount){
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
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

    public void setNumberPurchasedTickets(int numberPurchasedTickets) { this.numberPurchasedTickets = numberPurchasedTickets; }

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

}
