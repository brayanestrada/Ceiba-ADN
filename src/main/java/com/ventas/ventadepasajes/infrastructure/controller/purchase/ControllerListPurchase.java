package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerListPurchase;
import com.ventas.ventadepasajes.domain.model.dto.DtoPurchase;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class ControllerListPurchase {

    private final HandlerListPurchase handlerListPurchase;

    public ControllerListPurchase(HandlerListPurchase handlerListPurchase){
        this.handlerListPurchase = handlerListPurchase;
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<DtoPurchase> listPurchase(){
        return handlerListPurchase.run();
    }
}
