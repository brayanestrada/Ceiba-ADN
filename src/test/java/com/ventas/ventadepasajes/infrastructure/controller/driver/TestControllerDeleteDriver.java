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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerDeleteDriver {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void deleteUser() throws Exception {
        if(callRequestCreateDriver()){
            callRequestDeleteDriver(1);
            if (
            callRequestCreateDriver()){
                callRequestDeleteDriver(2);
            }else{
                throw new ExceptionGeneral("Error creating Driver on Delete User Test");
            }
        }else{
            throw new ExceptionGeneral("Error creating Driver on Delete User Test");
        }
    }

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


    private String callRequestDeleteDriver(long id) throws Exception {
        MvcResult mvcResult =  mockMvc.perform(delete("/driver/delete/"+id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        return mvcResult.getResponse().getContentAsString();
    }

}
