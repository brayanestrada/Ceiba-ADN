package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerCreatePurchase;
import com.ventas.ventadepasajes.domain.exceptions.ExceptionParsing;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase")
public class ControllerCreatePurchase {

    private HandlerCreatePurchase handlerCreatePurchase;

    public ControllerCreatePurchase(HandlerCreatePurchase handlerCreatePurchase){
        this.handlerCreatePurchase = handlerCreatePurchase;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPurchase(@RequestBody CommandPurchase commandPurchase) throws ExceptionParsing {
        this.handlerCreatePurchase.run(commandPurchase);
    }
}
