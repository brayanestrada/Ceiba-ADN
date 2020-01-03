package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;

public class PurchaseTestDataBuilder {

    private long idTest = 1;
    private int numberPurchasedTicketsTest = 2;
    private double ticketAmountTest = 5000;
    private int discountPercentageTest = 0;
    private double totalPurchaseAmountTest = 25000;
    private String purchaseDateTest = "2020-01-01";
    private long idTripTest = 1;
    private String tripDateTest = "2020-01-01";

    public PurchaseTestDataBuilder(){}

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

    public Purchase buildMonday4Tickets(){
        int tickets = 4;
        String tripDate = "2020-01-06";
        return new Purchase(this.idTest, tickets, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, tripDate);
    }

    public Purchase buildThursday4Tickets(){
        int tickets = 4;
        String tripDate = "2020-01-09";
        return new Purchase(this.idTest, tickets, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, tripDate);
    }

    public Purchase buildFriday4Tickets(){
        int tickets = 4;
        String tripDate = "2020-01-10";
        return new Purchase(this.idTest, tickets, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, tripDate);
    }

    public Purchase buildMonday3Tickets(){
        int tickets = 3;
        String tripDate = "2020-01-06";
        return new Purchase(this.idTest, tickets, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, tripDate);
    }

    public Purchase buildThursday3Tickets(){
        int tickets = 3;
        String tripDate = "2020-01-09";
        return new Purchase(this.idTest, tickets, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, tripDate);
    }

    public Purchase buildFriday3Tickets(){
        int tickets = 3;
        String tripDate = "2020-01-10";
        return new Purchase(this.idTest, tickets, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, tripDate);
    }



}
