package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.CommandUser;
import com.ventas.ventadepasajes.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class FactoryUser {
    public User create(CommandUser commandUser){
        return new User(commandUser.getId(), commandUser.getName(), commandUser.getLastName());
    }
}
