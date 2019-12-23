package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;

public class CommandPurchaseDataBuilder {

    private long idTrip;
    private int numberPurchasedTickets;

    public CommandPurchaseDataBuilder(){
        this.idTrip = 1;
        this.numberPurchasedTickets = 3;
    }

    public CommandPurchase build(){ return new CommandPurchase(numberPurchasedTickets, idTrip);}
}
