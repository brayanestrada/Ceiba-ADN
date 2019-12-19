package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.ventas.ventadepasajes.aplication.command.handler.user.HandlerDeleteUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ControllerDeleteUser {

    private final HandlerDeleteUser handlerDeleteUser;

    public ControllerDeleteUser(HandlerDeleteUser handlerDeleteUser){
        this.handlerDeleteUser = handlerDeleteUser;
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUse(@PathVariable long id){
        if(handlerDeleteUser.run(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
