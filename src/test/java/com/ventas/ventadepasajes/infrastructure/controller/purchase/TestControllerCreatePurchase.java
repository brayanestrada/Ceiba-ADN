package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandPurchaseDataBuilder;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandTripDataBuilder;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerCreatePurchase {


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    private CountDownLatch lock = new CountDownLatch(1);

    public void create() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        CommandTripDataBuilder commandTripDataBuilder = new CommandTripDataBuilder();
        CommandTrip commandTrip = commandTripDataBuilder.build();
        mockMvc.perform(post("/trip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isCreated()).andReturn();
        CommandPurchaseDataBuilder commandPurchaseDataBuilder = new CommandPurchaseDataBuilder();
        CommandPurchase commandPurchase = commandPurchaseDataBuilder.build();
        MockMvc secondMockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        lock.await(2000, TimeUnit.MILLISECONDS);
        secondMockMvc.perform(post("/purchase/create")
                .content(objectMapper.writeValueAsString(commandPurchase))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}
