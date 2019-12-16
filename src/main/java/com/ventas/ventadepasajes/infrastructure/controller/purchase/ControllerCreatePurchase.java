package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerCreatePurchase;
import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class ControllerCreatePurchase {

    private HandlerCreatePurchase handlerCreatePurchase;

    public ControllerCreatePurchase(HandlerCreatePurchase handlerCreatePurchase){
        this.handlerCreatePurchase = handlerCreatePurchase;
    }

    @PostMapping("/create")
    public DtoPurchase createPurchase(@RequestBody CommandPurchase commandPurchase){
        return this.handlerCreatePurchase.run(commandPurchase);
    }
}
