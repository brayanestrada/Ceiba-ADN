package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerCreatePurchase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class ControllerCreatePurchase {

    private HandlerCreatePurchase handlerCreatePurchase;

    public ControllerCreatePurchase(HandlerCreatePurchase handlerCreatePurchase){
        this.handlerCreatePurchase = handlerCreatePurchase;
    }

    @CrossOrigin
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPurchase(@RequestBody CommandPurchase commandPurchase){
        this.handlerCreatePurchase.run(commandPurchase);
    }
}
