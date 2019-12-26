package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerUpdateDriver {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
    private CommandDriver commandDriver;
    private CommandDriver commandDriverUpdated;

    private final String uriCreate = "/driver/create/";
    private final String uriList = "/driver/list/";
    private final String uriUpdate = "/driver/update/{id}";

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void updateDriver() throws Exception {
        commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildUpdate();
        assertTrue(callRequestUpdateDriver(id, commandDriverUpdated));
        String result = listDrivers();
    }

    @Test
    public void createBadDriverWithoutName() throws Exception{
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildWithoutName();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_NAME_IS_MANDATORY));
    }

    @Test
    public void createBadDriverWithoutLastName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildWithoutLastName();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_LAST_NAME_IS_MANDATORY));
    }

    @Test
    public void createBadDriverWithoutIdentification() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildWithoutIdentification();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_IDENTIFICATION_IS_MANDATORY));
    }

    @Test
    public void createBadDriverSmallName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildSmallName();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_NAME_MIN_LENGTH));
    }

    @Test
    public void createBadDriverSmallLastName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildSmallLastName();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_LAST_NAME_MIN_LENGTH));
    }

    @Test
    public void createBadDriverSmallIdentification() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildSmallIdentification();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_IDENTIFICATION_MIN_LENGTH));
    }

    @Test
    public void createBadDriverLongName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildLongName();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_NAME_MAX_LENGTH));
    }

    @Test
    public void createBadDriverLongLastName() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildLongLastName();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_LAST_NAME_MAX_LENGTH));
    }

    @Test
    public void createBadDriverLongIdentification() throws Exception {
        this.commandDriver = commandDriverDataBuilder.build();
        int id = callRequestCreateDriver(commandDriver);
        commandDriverUpdated = commandDriverDataBuilder.buildLongIdentification();
        assertTrue(callRequestUpdateBadDriver(id, commandDriverUpdated, ERROR_IDENTIFICATION_MAX_LENGTH));
    }


    private int callRequestCreateDriver(CommandDriver commandDriver) throws Exception {
        mockMvc.perform(post(uriCreate)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDriver)))
                .andExpect(status().isCreated());
        String result = listDrivers();
        return JsonPath.read(result, "$[0].id");
    }

    private Boolean callRequestUpdateBadDriver(int id, CommandDriver command, String message) throws Exception {
        MvcResult mvcResult = mockMvc.perform(put(uriUpdate, id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
        return true;
    }

    private boolean callRequestUpdateDriver(int id, CommandDriver commandDriverUpdated) throws Exception {
        mockMvc.perform(put(uriUpdate , id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDriverUpdated)))
                .andExpect(status().isOk());
        return true;
    }

    private String listDrivers() throws Exception {
        MvcResult mvcResult  = mockMvc.perform(get(uriList)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return mvcResult.getResponse().getContentAsString();
    }


}
