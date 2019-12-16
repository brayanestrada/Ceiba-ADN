package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDriverDataBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerUpdateDriver {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

   /* @Test
    public void update() throws Exception{
        if(callRequestCreateDriver()){
            ObjectMapper objectMapper = new ObjectMapper();
            CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
            CommandDriver commandDriver = commandDriverDataBuilder.build();
            mockMvc.perform(put("/driver/update/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(objectMapper.writeValueAsString(commandDriver)))
                    .andExpect(status().isOk());
        }else{
            throw new ExceptionGeneral("Error creating the driver on update driver");
        }
    }

*/
    private boolean callRequestCreateDriver(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
            CommandDriver commandDriver = commandDriverDataBuilder.build();
            mockMvc.perform(post("/driver/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(commandDriver)))
                    .andExpect(status().isCreated());
            return true;
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }
}
