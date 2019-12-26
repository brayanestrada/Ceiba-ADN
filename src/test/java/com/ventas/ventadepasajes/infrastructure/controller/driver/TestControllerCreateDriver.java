package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDriverDataBuilder;
import org.junit.Assert;
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

import static com.ventas.ventadepasajes.infrastructure.controller.driver.Utils.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerCreateDriver {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();

    private CommandDriver commandDriver;

    private String uri = "/driver/create";

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void createBadDriverWithoutName() throws Exception{
        this.commandDriver = commandDriverDataBuilder.buildWithoutName();
        callRequestCreateBadDriver(commandDriver, ERROR_NAME_IS_MANDATORY);
    }

    @Test
    public void createBadDriverWithoutLastName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildWithoutLastName();
        callRequestCreateBadDriver(commandDriver, ERROR_LAST_NAME_IS_MANDATORY);
    }

    @Test
    public void createBadDriverWithoutIdentification() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildWithoutIdentification();
        callRequestCreateBadDriver(commandDriver, ERROR_IDENTIFICATION_IS_MANDATORY);
    }

    @Test
    public void createCorrectDriver() throws Exception{
        this.commandDriver = commandDriverDataBuilder.build();
        callRequestCreateDriver(commandDriver);
    }

    @Test
    public void createBadDriverSmallName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildSmallName();
        callRequestCreateBadDriver(commandDriver, ERROR_NAME_MIN_LENGTH);
    }

    @Test
    public void createBadDriverSmallLastName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildSmallLastName();
        callRequestCreateBadDriver(commandDriver, ERROR_LAST_NAME_MIN_LENGTH);
    }

    @Test
    public void createBadDriverSmallIdentification() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildSmallIdentification();
        callRequestCreateBadDriver(commandDriver, ERROR_IDENTIFICATION_MIN_LENGTH);
    }

    @Test
    public void createBadDriverLongName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildLongName();
        callRequestCreateBadDriver(commandDriver, ERROR_NAME_MAX_LENGTH);
    }

    @Test
    public void createBadDriverLongLastName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildLongLastName();
        callRequestCreateBadDriver(commandDriver, ERROR_LAST_NAME_MAX_LENGTH);
    }

    @Test
    public void createBadDriverLongIdentification() throws Exception {
        this.commandDriver = commandDriverDataBuilder.buildLongIdentification();
        callRequestCreateBadDriver(commandDriver, ERROR_IDENTIFICATION_MAX_LENGTH);
    }


    private void callRequestCreateDriver(Object command) throws Exception {
        mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isCreated());
    }

    private String callRequestCreateBadDriver(Object command, String message) throws Exception {
        MvcResult mvcResult = mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
        return mvcResult.getResponse().getContentAsString();
    }

}
