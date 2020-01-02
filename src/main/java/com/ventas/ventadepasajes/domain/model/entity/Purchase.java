package com.ventas.ventadepasajes.domain.model.entity;

public class Purchase {

    private long idModel;
    private double totalPurchaseAmountModel;
    private int numberPurchasedTicketsModel;
    private double ticketAmountModel;
    private long idTripModel;
    private String purchaseDateModel;
    private String tripDateModel;
    private int discountPercentageModel;

    private static final String ERROR_DATE_FORMAT = "Error: Date hasn't the correct format, it's dd-MM-yyyy";
    private static final String ERROR_NUMBER_PURCHASED_TICKETS_MANDATORY = "Error: Number of purchased tickets is mandatory";
    private static final int MAX_ALLOWED_TICKETS = 15;
    private static final int MIN_ALLOWED_TICKETS = 0;
    private static final String ERROR_MAX_ALLOWED_TICKETS = "Error: Max number of tickets to purchase are " + MAX_ALLOWED_TICKETS;
    private static final String ERROR_MIN_ALLOWED_TICKETS = "Error: Min number of tickets to purchase are " + MIN_ALLOWED_TICKETS;
    private static final String ERROR_ID_TRIP_IS_MANDATORY = "Error: Trip id is mandatory";

    public Purchase(long id, int numberPurchasedTickets, double ticketAmount, int discountPercentage, double totalPurchaseAmount, long idTrip, String purchaseDate, String tripDate){
        validate(numberPurchasedTickets, idTrip);
        DataValidator.validateDateFormat(purchaseDate, ERROR_DATE_FORMAT);
        DataValidator.validateDateFormat(tripDate, ERROR_DATE_FORMAT);
        this.idModel = id;
        this.numberPurchasedTicketsModel = numberPurchasedTickets;
        this.purchaseDateModel = purchaseDate;
        this.ticketAmountModel = ticketAmount;
        this.idTripModel = idTrip;
        this.discountPercentageModel = discountPercentage;
        this.totalPurchaseAmountModel = totalPurchaseAmount;
        this.tripDateModel = tripDate;
    }

    public Purchase(long id, int numberPurchasedTickets, long idTrip){
        validate(numberPurchasedTickets, idTrip);
        this.idModel = id;
        this.discountPercentageModel = 0;
        this.totalPurchaseAmountModel = 0;
        this.numberPurchasedTicketsModel = numberPurchasedTickets;
        this.idTripModel = idTrip;
    }

    public Purchase(int numberPurchasedTickets, long idTrip){
        validate(numberPurchasedTickets, idTrip);
        this.numberPurchasedTicketsModel = numberPurchasedTickets;
        this.totalPurchaseAmountModel = 0;
        this.discountPercentageModel = 0;
        this.idTripModel = idTrip;
    }

    public long getId() {
        return idModel;
    }

    public void setId(long id) {
        this.idModel = id;
    }

    public int getNumberPurchasedTickets() {
        return numberPurchasedTicketsModel;
    }

    public double getTicketAmount() {
        return ticketAmountModel;
    }

    public void setTicketAmount(double ticketAmount) {
        this.ticketAmountModel = ticketAmount;
    }

    public double getTotalPurchaseAmount() {
        return totalPurchaseAmountModel;
    }

    public void setTotalPurchaseAmount(double totalPurchaseAmount) {
        this.totalPurchaseAmountModel = totalPurchaseAmount;
    }

    public int getDiscountPercentage() { return discountPercentageModel; }

    public void setDiscountPercentage(int discountPercentage) { this.discountPercentageModel = discountPercentage; }

    public long getIdTrip() {
        return idTripModel;
    }

    public String getPurchaseDate() {
        return purchaseDateModel;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDateModel = purchaseDate;
    }

    public String getTripDate() {
        return tripDateModel;
    }

    public void setTripDate(String tripDate) {
        this.tripDateModel = tripDate;
    }

    private void validate(int numberPurchasedTickets, long idTrip){
        DataValidator.validateNumberMandatory(idTrip, ERROR_ID_TRIP_IS_MANDATORY);
        DataValidator.validateNumberMandatory(numberPurchasedTickets, ERROR_NUMBER_PURCHASED_TICKETS_MANDATORY);
        DataValidator.validateMaximumValue(numberPurchasedTickets, MAX_ALLOWED_TICKETS, ERROR_MAX_ALLOWED_TICKETS);
        DataValidator.validateMinimumValue(numberPurchasedTickets, MIN_ALLOWED_TICKETS, ERROR_MIN_ALLOWED_TICKETS);
    }

}
