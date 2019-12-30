package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerDeletePurchase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase")
public class ControllerDeletePurchase {

    private HandlerDeletePurchase handlerDeletePurchase;

    public ControllerDeletePurchase(HandlerDeletePurchase handlerDeletePurchase){
        this.handlerDeletePurchase = handlerDeletePurchase;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deletePurchase(@PathVariable long id){
        if(handlerDeletePurchase.run(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
