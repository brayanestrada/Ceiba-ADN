package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerListPurchase;
import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class ControllerListPurchase {

    private final HandlerListPurchase handlerListPurchase;

    public ControllerListPurchase(HandlerListPurchase handlerListPurchase){
        this.handlerListPurchase = handlerListPurchase;
    }

    @GetMapping("/list")
    public List<Purchase> listPurchase(){
        return handlerListPurchase.run();
    }
}
