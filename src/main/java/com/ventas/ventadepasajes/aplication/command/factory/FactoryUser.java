package com.ventas.ventadepasajes.aplication.command.factory;

import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.domain.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FactoryUser {

    public User create(CommandUser commandUser){
        return new User(commandUser.getNameCommand(), commandUser.getLastNameCommand(), commandUser.getEmailCommand(), commandUser.getPhoneCommand(), commandUser.getRoleCommand(), commandUser.getPasswordCommand());
    }

    public User update(long id, CommandUser commandUser){return new User(id, commandUser.getNameCommand(), commandUser.getLastNameCommand(), commandUser.getEmailCommand(), commandUser.getPhoneCommand(), commandUser.getRoleCommand(), commandUser.getPasswordCommand());}
}