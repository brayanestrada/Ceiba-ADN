package com.ventas.ventadepasajes.infrastructure.controller.Trip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDriverDataBuilder;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandTripDataBuilder;
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerUpdateTrip {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
    private CommandTripDataBuilder commandTripDataBuilder = new CommandTripDataBuilder();

    private final String uriUpdateTrip = "/trip/update/{id}";

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void updateTrip() throws Exception {
        CommandDriver commandDriver = commandDriverDataBuilder.build();
        int idDriver = callRequestCreateDriver(commandDriver);
        CommandTrip commandTrip = commandTripDataBuilder.build();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);
        int idTrip = callRequestCreateTrip(commandTrip);
        CommandTrip commandTripUpdated = commandTripDataBuilder.build();
        commandTripUpdated = commandTripDataBuilder.buildWithDriverId(commandTripUpdated, idDriver);
        assertTrue(callRequestUpdateTrip(idTrip, commandTripUpdated));
    }


    private int callRequestCreateDriver(CommandDriver commandDriver) throws Exception {
        String uriCreateDriver = "/driver/create/";
        mockMvc.perform(post(uriCreateDriver)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDriver)))
                .andExpect(status().isCreated());
        String result = listDrivers();
        return JsonPath.read(result, "$[0].id");
    }

    private int callRequestCreateTrip(CommandTrip commandTrip) throws Exception {
        String uriCreateTrip = "/trip/create/";
        mockMvc.perform(post(uriCreateTrip)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isCreated());
        String result = listTrips();
        return JsonPath.read(result, "$[0].id");
    }

    private Boolean callRequestUpdateTrip(int id, CommandTrip commandTrip) throws Exception {
        mockMvc.perform(put(uriUpdateTrip, id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isOk());
        return true;
    }

    private Boolean callRequestUpdateBadTrip(int id, CommandTrip commandTrip, String message) throws Exception {
        MvcResult mvcResult = mockMvc.perform(put(uriUpdateTrip, id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
        return true;
    }

    private String listTrips() throws Exception {
        String uriListTrip = "/trip/list";
        MvcResult mvcResult  = mockMvc.perform(get(uriListTrip)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return mvcResult.getResponse().getContentAsString();
    }

    private String listDrivers() throws Exception {
        String uriListDrivers = "/driver/list/";
        MvcResult mvcResult  = mockMvc.perform(get(uriListDrivers)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return mvcResult.getResponse().getContentAsString();
    }
}
