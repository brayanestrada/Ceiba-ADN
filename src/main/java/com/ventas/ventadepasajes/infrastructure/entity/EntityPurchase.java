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
    private String purchaseDate;
    private String tripDate;
    private long idTrip;

    private EntityPurchase(){}

    public EntityPurchase(long id, int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount, long idTrip, String purchaseDate, String tripDate){
        this.id = id;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.purchaseDate = purchaseDate;
        this.tripDate = tripDate;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.discountPercentage = discountPercentage;
        this.ticketAmount = ticketAmount;
        this.idTrip = idTrip;
    }

    public long getIdEntity() {
        return id;
    }

    public void setIdEntity(long id) {
        this.id = id;
    }

    public int getNumberPurchasedTicketsEntity() {
        return numberPurchasedTickets;
    }

    public void setNumberPurchasedTicketsEntity(int numberPurchasedTickets) { this.numberPurchasedTickets = numberPurchasedTickets; }

    public double getTicketAmountEntity() {
        return ticketAmount;
    }

    public void setTicketAmountEntity(double ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public double getTotalPurchaseAmountEntity() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmountEntity(double totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public int getDiscountPercentageEntity() { return discountPercentage; }

    public void setDiscountPercentageEntity(int discountPercentage) { this.discountPercentage = discountPercentage; }

    public long getIdTripEntity() {
        return idTrip;
    }

    public void setIdTripEntity(long idTrip) {
        this.idTrip = idTrip;
    }

    public String getPurchaseDateEntity() {
        return purchaseDate;
    }

    public void setPurchaseDateEntity(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getTripDateEntity() {
        return tripDate;
    }

    public void setTripDateEntity(String tripDate) {
        this.tripDate = tripDate;
    }
}
