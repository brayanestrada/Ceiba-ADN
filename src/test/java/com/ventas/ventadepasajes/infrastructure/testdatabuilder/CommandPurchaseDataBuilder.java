package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;

public class CommandPurchaseDataBuilder {

    private long idTrip = 1;
    private int numberPurchasedTickets = 5;

    public CommandPurchase build(){ return new CommandPurchase(numberPurchasedTickets, idTrip);}

    public CommandPurchase buildWithoutTripId(CommandPurchase commandPurchase, int idTrip) { return new CommandPurchase(commandPurchase.getNumberPurchasedTickets(), idTrip); }

    public CommandPurchase buildWithoutNumberPurchasedTickets() { return  new CommandPurchase(0, idTrip); }

    public CommandPurchase buildMinimumValueNumberPurchasedTickets(){ return new CommandPurchase(-1, idTrip); }

    public CommandPurchase buildMaximumValueNumberPurchasedTickets() { return new CommandPurchase(16, idTrip); }
}
