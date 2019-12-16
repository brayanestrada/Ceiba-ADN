package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.ventas.ventadepasajes.aplication.command.handler.driver.HandlerListDriver;
import com.ventas.ventadepasajes.domain.model.dto.DtoDriver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class ControllerListDriver {

    private final HandlerListDriver handlerListDriver;

    public ControllerListDriver(HandlerListDriver handlerListDriver){
        this.handlerListDriver = handlerListDriver;

    }

    @GetMapping("/list")
    public List<DtoDriver> driverList(){
        return this.handlerListDriver.run();
    }
}
