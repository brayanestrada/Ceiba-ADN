package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.ventas.ventadepasajes.aplication.command.handler.purchase.HandlerDeletePurchase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class ControllerDeletePurchase {

    private HandlerDeletePurchase handlerDeletePurchase;

    public ControllerDeletePurchase(HandlerDeletePurchase handlerDeletePurchase){
        this.handlerDeletePurchase = handlerDeletePurchase;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePurchase(@PathVariable long id){
        if(handlerDeletePurchase.run(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
