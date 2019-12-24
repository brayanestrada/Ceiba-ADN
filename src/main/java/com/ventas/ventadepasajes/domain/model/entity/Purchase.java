package com.ventas.ventadepasajes.domain.model.entity;

public class Purchase {

    private long id;
    private int numberPurchasedTickets;
    private double ticketAmount;
    private int discountPercentage;
    private double totalPurchaseAmount;
    private String purchaseDate;
    private long idTrip;
    private String tripDate;

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
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.ticketAmount = ticketAmount;
        this.discountPercentage = discountPercentage;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.idTrip = idTrip;
        this.purchaseDate = purchaseDate;
        this.tripDate = tripDate;
    }

    public Purchase(long id, int numberPurchasedTickets, long idTrip){
        validate(numberPurchasedTickets, idTrip);
        this.id = id;
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.discountPercentage = 0;
        this.totalPurchaseAmount = 0;
        this.idTrip = idTrip;
    }

    public Purchase(int numberPurchasedTickets, long idTrip){
        validate(numberPurchasedTickets, idTrip);
        this.numberPurchasedTickets = numberPurchasedTickets;
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

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    private void validate(int numberPurchasedTickets, long idTrip){
        DataValidator.validateNumberMandatory(idTrip, ERROR_ID_TRIP_IS_MANDATORY);
        DataValidator.validateNumberMandatory(numberPurchasedTickets, ERROR_NUMBER_PURCHASED_TICKETS_MANDATORY);
        DataValidator.validateMaximumValue(numberPurchasedTickets, MAX_ALLOWED_TICKETS, ERROR_MAX_ALLOWED_TICKETS);
        DataValidator.validateMinimumValue(numberPurchasedTickets, MIN_ALLOWED_TICKETS, ERROR_MIN_ALLOWED_TICKETS);
    }

}
