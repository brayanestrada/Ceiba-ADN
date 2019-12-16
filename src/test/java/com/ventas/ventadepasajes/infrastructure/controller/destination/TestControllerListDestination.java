package com.ventas.ventadepasajes.infrastructure.controller.destination;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDestination;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDestinationDataBuilder;
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

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
@Transactional
public class TestControllerListDestination {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void list() throws Exception{
        String result = callRequest();
        System.out.println(result);
        if (result.equals("[]")){
            createDestination();
            result = callRequest();
            System.out.println(result);
            if (result.equals("[]")){
                fail("Error = Destination list is empty");
            }
        }else{
            fail("Error = Destination list is not empty");
        }
    }

    private String callRequest() throws Exception {
        MvcResult mvcResult =  mockMvc.perform(get("/destination/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        return mvcResult.getResponse().getContentAsString();
    }

    private void createDestination() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CommandDestinationDataBuilder commandDestinationDataBuilder = new CommandDestinationDataBuilder();
        CommandDestination commandDestination = commandDestinationDataBuilder.build();
        System.out.println(commandDestination);
        mockMvc.perform(post("/destination/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDestination)))
                .andExpect(status().isCreated());
    }

}
