package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDriverDataBuilder;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandPurchaseDataBuilder;
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

import static com.ventas.ventadepasajes.infrastructure.controller.purchase.Utils.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerUpdatePurchase {


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandPurchaseDataBuilder commandPurchaseDataBuilder = new CommandPurchaseDataBuilder();
    private CommandPurchase commandPurchase;
    private CommandPurchase commandPurchaseUpdated;
    private CommandTripDataBuilder commandTripDataBuilder = new CommandTripDataBuilder();
    private CommandTrip commandTrip;
    private CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
    private CommandDriver commandDriver;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void updatePurchase() throws Exception {
        commandDriver = commandDriverDataBuilder.build();
        int idDriver = callRequestCreateDriver(commandDriver);
        commandTrip = commandTripDataBuilder.build();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);
        int idTrip = callRequestCreateTrip(commandTrip);
        commandPurchase = commandPurchaseDataBuilder.build();
        commandPurchase = commandPurchaseDataBuilder.buildWithTripId(commandPurchase, idTrip);
        int idPurchase = callRequestCreatePurchase(commandPurchase);
        commandPurchaseUpdated = commandPurchaseDataBuilder.buildUpdated(idTrip);
        callRequestUpdatePurchase(idPurchase, commandPurchaseUpdated);
    }


    @Test
    public void updateBadPurchaseWithoutNumberPurchasedTickets() throws Exception {
        commandDriver = commandDriverDataBuilder.build();
        int idDriver = callRequestCreateDriver(commandDriver);
        commandTrip = commandTripDataBuilder.build();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);
        int idTrip = callRequestCreateTrip(commandTrip);
        commandPurchase = commandPurchaseDataBuilder.build();
        commandPurchase = commandPurchaseDataBuilder.buildWithTripId(commandPurchase, idTrip);
        int idPurchase = callRequestCreatePurchase(commandPurchase);
        commandPurchaseUpdated = commandPurchaseDataBuilder.buildWithoutNumberPurchasedTickets(idTrip);
        callRequestUpdateBadPurchase(idPurchase, commandPurchaseUpdated, ERROR_NUMBER_PURCHASED_TICKETS_MANDATORY);
    }


    @Test
    public void updateBadPurchaseMinimumNumberPurchasedTickets() throws Exception {
        commandDriver = commandDriverDataBuilder.build();
        int idDriver = callRequestCreateDriver(commandDriver);
        commandTrip = commandTripDataBuilder.build();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);
        int idTrip = callRequestCreateTrip(commandTrip);
        commandPurchase = commandPurchaseDataBuilder.build();
        commandPurchase = commandPurchaseDataBuilder.buildWithTripId(commandPurchase, idTrip);
        int idPurchase = callRequestCreatePurchase(commandPurchase);
        commandPurchaseUpdated = commandPurchaseDataBuilder.buildMinimumValueNumberPurchasedTickets(idTrip);
        callRequestUpdateBadPurchase(idPurchase, commandPurchaseUpdated, ERROR_MIN_ALLOWED_TICKETS);
    }


    @Test
    public void updateBadPurchaseMaximumNumberPurchasedTickets() throws Exception {
        commandDriver = commandDriverDataBuilder.build();
        int idDriver = callRequestCreateDriver(commandDriver);
        commandTrip = commandTripDataBuilder.build();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);
        int idTrip = callRequestCreateTrip(commandTrip);
        commandPurchase = commandPurchaseDataBuilder.build();
        commandPurchase = commandPurchaseDataBuilder.buildWithTripId(commandPurchase, idTrip);
        int idPurchase = callRequestCreatePurchase(commandPurchase);
        commandPurchaseUpdated = commandPurchaseDataBuilder.buildMaximumValueNumberPurchasedTickets(idTrip);
        callRequestUpdateBadPurchase(idPurchase, commandPurchaseUpdated, ERROR_MAX_ALLOWED_TICKETS);
    }


    private int callRequestCreateDriver(CommandDriver commandDriver) throws Exception {
        mockMvc.perform(post("/api/driver/create/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDriver)))
                .andExpect(status().isCreated());
        String result = listDrivers();
        return JsonPath.read(result, "$[0].id");
    }

    private int callRequestCreateTrip(CommandTrip commandTrip) throws Exception {
        mockMvc.perform(post("/api/trip/create/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isCreated());
        String result = listTrips();
        return JsonPath.read(result, "$[0].id");
    }

    private int callRequestCreatePurchase(CommandPurchase commandPurchase) throws Exception {
        mockMvc.perform(post("/api/purchase/create/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandPurchase)))
                .andExpect(status().isCreated());
        String result = listTrips();
        return JsonPath.read(result, "$[0].id");
    }

    private void callRequestUpdatePurchase(int id, CommandPurchase commandPurchase) throws Exception {
        mockMvc.perform(put("/api/purchase/update/{id}" , id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandPurchase)))
                .andExpect(status().isOk());
    }

    private void callRequestUpdateBadPurchase(int id, CommandPurchase commandPurchase, String message) throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/api/purchase/update/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandPurchase)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
    }

    private String listTrips() throws Exception {
        MvcResult mvcResult  = mockMvc.perform(get("/api/trip/list/")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return mvcResult.getResponse().getContentAsString();
    }

    private String listDrivers() throws Exception {
        MvcResult mvcResult  = mockMvc.perform(get("/api/driver/list/")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return mvcResult.getResponse().getContentAsString();
    }

}
