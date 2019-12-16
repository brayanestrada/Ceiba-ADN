package com.ventas.ventadepasajes.aplication.command.handler.command;

import lombok.ToString;

@ToString
public class CommandPurchase {
    private long id;
    private int numberPurchasedTickets;
    private double ticketAmount;

    public CommandPurchase(){}

    public long getId() {
        return id;
    }

    public int getNumberPurchasedTickets() {
        return numberPurchasedTickets;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }
}
