package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.aplication.command.handler.driver.HandlerCreateDriver;
import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class ControllerCreateDriver {

    private HandlerCreateDriver handlerCreateDriver;

    public ControllerCreateDriver(HandlerCreateDriver handlerCreateDriver){
        this.handlerCreateDriver = handlerCreateDriver; }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DtoDriver createDriver(@RequestBody CommandDriver commandDriver){
        return this.handlerCreateDriver.run(commandDriver);
    }
}
