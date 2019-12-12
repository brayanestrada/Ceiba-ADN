package com.ventas.ventadepasajes.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.factory.FactoryDestination;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;
import com.ventas.ventadepasajes.aplication.command.handler.destination.HandlerCreateDestination;
import com.ventas.ventadepasajes.domain.model.dto.DtoDestination;
import com.ventas.ventadepasajes.domain.service.destination.ServiceCreateDestination;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDestinationDataBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
public class TestControllerUser {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void create() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        CommandDestination commandDestination = new CommandDestinationDataBuilder().build();
        System.out.println("Inicio");
        mockMvc.perform(post("/destination/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDestination)))
                .andExpect(status().isCreated());
        System.out.println("Final");
    }
}
