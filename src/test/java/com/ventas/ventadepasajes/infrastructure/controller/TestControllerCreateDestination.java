package com.ventas.ventadepasajes.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDestinationDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
                classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
@DependsOn("TestControllerListDestination")
public class TestControllerCreateDestination {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void create() throws Exception{
        CommandDestinationDataBuilder commandDestinationDataBuilder = new CommandDestinationDataBuilder();
        CommandDestination commandDestination = commandDestinationDataBuilder.build();
        callRequest(commandDestination);
        commandDestinationDataBuilder.withName("Medellin");
        commandDestination = commandDestinationDataBuilder.build();
        callRequest(commandDestination);
    }

    private void callRequest(CommandDestination commandDestination) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/destination/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDestination)))
                .andExpect(status().isCreated());
    }
}
