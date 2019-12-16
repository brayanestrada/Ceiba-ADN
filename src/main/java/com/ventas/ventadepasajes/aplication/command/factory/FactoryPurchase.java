package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class FactoryPurchase {

    public FactoryPurchase(){}

    public Purchase create(CommandPurchase commandPurchase){
        return new Purchase(commandPurchase.getNumberPurchasedTickets(), commandPurchase.getTicketAmount());
    }

    public Purchase update(long id, CommandPurchase commandPurchase){
        return new Purchase(id, commandPurchase.getNumberPurchasedTickets(), commandPurchase.getTicketAmount());
    }

}
