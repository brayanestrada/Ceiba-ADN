package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerUpdatePurchase;
import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class ControllerUpdatePurchase {
    private HandlerUpdatePurchase handlerUpdatePurchase;

    public ControllerUpdatePurchase(HandlerUpdatePurchase handlerUpdatePurchase){
        this.handlerUpdatePurchase = handlerUpdatePurchase;
    }

    @PutMapping("/update/{id}")
    public DtoPurchase update(@RequestBody CommandPurchase commandPurchase, @PathVariable long id){
        return this.handlerUpdatePurchase.run(id, commandPurchase);
    }
}
