package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.aplication.command.handler.driver.HandlerUpdateDriver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
public class ControllerUpdateDriver {
    private HandlerUpdateDriver handlerUpdateDriver;

    public ControllerUpdateDriver(HandlerUpdateDriver handlerUpdateDriver){
        this.handlerUpdateDriver = handlerUpdateDriver;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDriver(@RequestBody CommandDriver commandDriver, @PathVariable long id){
        this.handlerUpdateDriver.run(id, commandDriver);
    }
}
