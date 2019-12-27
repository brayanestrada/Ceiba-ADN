package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.aplication.command.handler.driver.HandlerCreateDriver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class ControllerCreateDriver {

    private HandlerCreateDriver handlerCreateDriver;

    public ControllerCreateDriver(HandlerCreateDriver handlerCreateDriver){
        this.handlerCreateDriver = handlerCreateDriver; }

    @CrossOrigin
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDriver(@RequestBody CommandDriver commandDriver){
        this.handlerCreateDriver.run(commandDriver);
    }
}
