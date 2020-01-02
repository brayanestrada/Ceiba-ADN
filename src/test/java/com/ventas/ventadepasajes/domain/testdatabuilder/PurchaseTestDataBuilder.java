package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;

public class PurchaseTestDataBuilder {

    private long idTest = 1;
    private int numberPurchasedTicketsTest = 5;
    private double ticketAmountTest = 5000;
    private int discountPercentageTest = 10;
    private double totalPurchaseAmountTest = 25000;
    private String purchaseDateTest = "2020-01-01";
    private long idTripTest = 1;
    private String tripDateTest = "2019-12-03";
    private int moreThanFourTickets = 5;

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

    public Purchase buildMoreThanFourTickets(){ return new Purchase(this.idTest, 5, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, this.tripDateTest); }

    public Purchase buildSaturday(){ return new Purchase(this.idTest, this.numberPurchasedTicketsTest, this.ticketAmountTest, this.discountPercentageTest, this.totalPurchaseAmountTest, this.idTripTest, this.purchaseDateTest, "2020-01-04"); }

}
