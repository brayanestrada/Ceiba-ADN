package com.ventas.ventadepasajes.infrastructure.testdatabuilder;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;

public class CommandPurchaseDataBuilder {

    private long idTrip = 1;
    private int numberPurchasedTickets = 5;
    private int numberPurchasedTicketsUpdated = 10;

    public CommandPurchase build(){ return new CommandPurchase(numberPurchasedTickets, idTrip);}

    public CommandPurchase buildUpdated(int idTrip){ return new CommandPurchase(numberPurchasedTicketsUpdated, idTrip);}

    public CommandPurchase buildWithTripId(CommandPurchase commandPurchase, int idTrip) { return new CommandPurchase(commandPurchase.getNumberPurchasedTickets(), idTrip); }

    public CommandPurchase buildWithoutNumberPurchasedTickets() { return  new CommandPurchase(0, idTrip); }

    public CommandPurchase buildWithoutNumberPurchasedTickets(int idTrip) { return  new CommandPurchase(0, idTrip); }

    public CommandPurchase buildMinimumValueNumberPurchasedTickets(){ return new CommandPurchase(-1, idTrip); }

    public CommandPurchase buildMinimumValueNumberPurchasedTickets(int idTrip){ return new CommandPurchase(-1, idTrip); }

    public CommandPurchase buildMaximumValueNumberPurchasedTickets() { return new CommandPurchase(16, idTrip); }

    public CommandPurchase buildMaximumValueNumberPurchasedTickets(int idTrip) { return new CommandPurchase(16, idTrip); }
}
