package com.ventas.ventadepasajes.aplication.command.handler.user;

import com.ventas.ventadepasajes.aplication.command.CommandUser;
import com.ventas.ventadepasajes.aplication.command.factory.FactoryUser;
import com.ventas.ventadepasajes.domain.model.User;
import com.ventas.ventadepasajes.domain.service.user.ServiceCreateUser;
import com.ventas.ventadepasajes.port.repository.RepositoryUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestHandlerCreateUser {

    @Autowired
    private RepositoryUser repositoryUser;

    @Test
    public void testCreateUser(){
        CommandUser commandUser = new CommandUser((long) 1, "Brayan", "Estrada");
        FactoryUser factoryUser = new FactoryUser();
        factoryUser.create(commandUser);
        ServiceCreateUser serviceCreateUser = new ServiceCreateUser(repositoryUser);
        HandlerCreateUser handlerCreateUser = new HandlerCreateUser(serviceCreateUser, factoryUser);
        User user = handlerCreateUser.run(commandUser);
        assertThat(user).isEqualToComparingFieldByField(commandUser);
    }
}
