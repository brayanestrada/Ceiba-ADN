package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerUpdatePurchase;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/purchase")
public class ControllerUpdatePurchase {
    private HandlerUpdatePurchase handlerUpdatePurchase;

    public ControllerUpdatePurchase(HandlerUpdatePurchase handlerUpdatePurchase){
        this.handlerUpdatePurchase = handlerUpdatePurchase;
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody CommandPurchase commandPurchase, @PathVariable long id) throws ParseException {
        this.handlerUpdatePurchase.run(id, commandPurchase);
    }
}
