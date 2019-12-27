package com.ventas.ventadepasajes.aplication.command.handler.command;

public class CommandPurchase {
    
    private int numberPurchasedTickets;
    private long idTrip;

    public CommandPurchase(int numberPurchasedTickets, long idTrip){
        this.numberPurchasedTickets = numberPurchasedTickets;
        this.idTrip = idTrip;

    }

    public int getNumberPurchasedTickets() {
        return numberPurchasedTickets;
    }

    public long getIdTrip() {
        return idTrip;
    }
}
