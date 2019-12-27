package com.ventas.ventadepasajes.infrastructure.controller.purchase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandPurchase;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDriverDataBuilder;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandPurchaseDataBuilder;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandRoleDataBuilder;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerCreatePurchase {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandPurchaseDataBuilder commandPurchaseDataBuilder = new CommandPurchaseDataBuilder();
    private CommandPurchase commandPurchase;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void createPurchase() throws Exception {
        commandPurchase = commandPurchaseDataBuilder.build();
        assertTrue(callCreatePurchase(commandPurchase));
    }

    @Test
    public void createBadPurchaseWithoutNumberPurchasedTickets() throws Exception {
        commandPurchase = commandPurchaseDataBuilder.buildWithoutNumberPurchasedTickets();
        callCreateBadPurchase(commandPurchase, ERROR_NUMBER_PURCHASED_TICKETS_MANDATORY);
    }

    @Test
    public void createBadPurchaseMinimumNumberPurchasedTickets() throws Exception {
        commandPurchase = commandPurchaseDataBuilder.buildMinimumValueNumberPurchasedTickets();
        callCreateBadPurchase(commandPurchase, ERROR_MIN_ALLOWED_TICKETS);
    }

    @Test
    public void createBadPurchaseMaximumNumberPurchasedTickets() throws Exception {
        commandPurchase = commandPurchaseDataBuilder.buildMaximumValueNumberPurchasedTickets();
        callCreateBadPurchase(commandPurchase, ERROR_MAX_ALLOWED_TICKETS);
    }

    public Boolean callCreatePurchase(CommandPurchase commandPurchase) throws Exception {
        int tripId = callCreateTrip();
        commandPurchase = commandPurchaseDataBuilder.buildWithTripId(commandPurchase,tripId);
        mockMvc.perform(post("/purchase/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandPurchase)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/purchase/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        System.out.println(mvc);
        return true;
    }

    public Boolean callCreateBadPurchase(CommandPurchase commandPurchase, String message) throws Exception {
        int tripId = callCreateTrip();
        commandPurchase = commandPurchaseDataBuilder.buildWithTripId(commandPurchase,tripId);
        MvcResult mvcResult = mockMvc.perform(post("/purchase/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandPurchase)))
                .andExpect(status().isBadRequest()).andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
        return true;
    }

    private int callCreateDriver() throws Exception {
        CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
        CommandDriver commandRole = commandDriverDataBuilder.build();
        mockMvc.perform(post("/driver/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandRole)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/driver/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        System.out.println(mvc);
        return JsonPath.read(mvc, "$[0].id");
    }

    private int callCreateTrip() throws Exception {
        int idDriver = callCreateDriver();
        CommandTripDataBuilder commandTripDataBuilder = new CommandTripDataBuilder();
        CommandTrip commandTrip = commandTripDataBuilder.build();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);

        mockMvc.perform(post("/trip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/trip/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        System.out.println(mvc);
        return JsonPath.read(mvc, "$[0].id");
    }
}
