package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;

public class PurchaseTestDataBuilder {

    private long idTest;
    private int numberPurchasedTicketsTest;
    private double ticketAmountTest;
    private int discountPercentageTest;
    private double totalPurchaseAmountTest;
    private String purchaseDateTest;
    private long idTripTest;
    private String tripDateTest;

    public PurchaseTestDataBuilder(){
        this.idTest = 1;
        this.numberPurchasedTicketsTest = 5;
        this.ticketAmountTest = 5000;
        this.discountPercentageTest = 10;
        this.totalPurchaseAmountTest = 25000;
        this.purchaseDateTest = "2020-01-01";
        this.idTripTest = 1;
        this.tripDateTest = "2019-12-03";
    }

    public void withoutIdTrip(){
        this.idTripTest = 0;
    }

    public void withoutPurchasedTickets(){
        this.numberPurchasedTicketsTest = 0;
    }

    public void maximumPurchasedTickets(){
        this.numberPurchasedTicketsTest = 16;
    }

    public void minimumPurchasedTickets(){
        this.numberPurchasedTicketsTest = 0;
    }

    public void tripDateFormat(){
        this.tripDateTest = "12/12/2019";
    }

    public void purchaseDateFormat(){
        this.tripDateTest = "12/12/2019";
    }

    public Purchase minimalBuildWithoutId(){ return new Purchase(this.numberPurchasedTicketsTest, this.idTripTest); }

    public Purchase minimalBuild(){ return new Purchase(this.idTest, this.numberPurchasedTicketsTest, this.idTripTest); }

    public Purchase build(){ return new Purchase(this.idTest, this.numberPurchasedTicketsTest, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, this.tripDateTest); }
}
