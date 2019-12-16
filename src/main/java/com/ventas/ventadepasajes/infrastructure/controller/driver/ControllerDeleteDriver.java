package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.ventas.ventadepasajes.aplication.command.handler.driver.HandlerDeleteDriver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class ControllerDeleteDriver{

    private final HandlerDeleteDriver handlerDeleteDriver;

    public ControllerDeleteDriver(HandlerDeleteDriver handlerDeleteDriver){
        this.handlerDeleteDriver = handlerDeleteDriver;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDriver(@PathVariable Long id) {
        if(handlerDeleteDriver.run(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
