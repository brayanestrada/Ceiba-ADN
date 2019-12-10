package com.ventas.ventadepasajes;

import com.ventas.ventadepasajes.controller.UserController;
import com.ventas.ventadepasajes.entity.User;
import com.ventas.ventadepasajes.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JUnitControllerTest {

    @Autowired
    UserService service = new UserService();

    @Test
    public void addUser(){
        User user = new User(1, "Brayan", "Estrada", "asdasd");
        UserController userController = new UserController();
        User userReturned = service.saveUser(user);
        Assert.assertEquals(user.toString(), userReturned.toString());
    }

}
