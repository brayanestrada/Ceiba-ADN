package com.ventas.ventadepasajes;

import com.ventas.ventadepasajes.controller.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JUnitControllerTest {

    @Test
    public void testGetusers(){
        UserController userController = new UserController();
        String result = userController.findUsers();
        assertThat(result).isEqualTo("Testing successful Brayan");
    }
}
