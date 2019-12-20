package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandPurchase {
    private long id;
    private int numberPurchasedTickets;
    private double ticketAmount;
    private long idTrip;

    public CommandPurchase() { }

    public long getId() {
        return id;
    }

    public int getNumberPurchasedTickets() {
        return numberPurchasedTickets;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public long getIdTrip() {
        return idTrip;
    }
}
