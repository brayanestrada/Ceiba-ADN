package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FactoryUser {

    public FactoryUser(){}

    public User create(CommandUser commandUser){
        return new User(commandUser.getName(), commandUser.getLastName(), commandUser.getEmail(), commandUser.getPhone());
    }

    public User update(long id, CommandUser commandUser){return new User(id, commandUser.getName(), commandUser.getLastName(), commandUser.getEmail(), commandUser.getPhone());}
}