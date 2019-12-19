package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.aplication.command.handler.driver.HandlerUpdateDriver;
import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class ControllerUpdateDriver {
    private HandlerUpdateDriver handlerUpdateDriver;

    public ControllerUpdateDriver(HandlerUpdateDriver handlerUpdateDriver){
        this.handlerUpdateDriver = handlerUpdateDriver;
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DtoDriver updateDriver(@RequestBody CommandDriver commandDriver, @PathVariable long id){
        return this.handlerUpdateDriver.run(id, commandDriver);
    }
}
