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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerDeletePurchase {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    private CommandPurchaseDataBuilder commandPurchaseDataBuilder = new CommandPurchaseDataBuilder();

    @Test
    public void deleteTrip() throws Exception {
        CommandPurchase commandPurchase = commandPurchaseDataBuilder.build();
        int id = callCreatePurchase(commandPurchase);
        callDeletePurchase(id);
        if(!callRequestListPurchase().contains("[]")){
            fail("Error, the record wasn't deleted");
        }
    }

    private String callRequestListPurchase() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/purchase/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return result.getResponse().getContentAsString();
    }

    private void callDeletePurchase(int id) throws Exception {
        mockMvc.perform(delete("/api/purchase/delete/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private int callCreateTrip() throws Exception {
        int idDriver = callCreateDriver();
        CommandTripDataBuilder commandTripDataBuilder = new CommandTripDataBuilder();
        CommandTrip commandTrip = commandTripDataBuilder.build();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);
        mockMvc.perform(post("/api/trip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/api/trip/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        return JsonPath.read(mvc, "$[0].id");
    }

    private int callCreateDriver() throws Exception {
        CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
        CommandDriver commandRole = commandDriverDataBuilder.build();
        mockMvc.perform(post("/api/driver/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandRole)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/api/driver/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        return JsonPath.read(mvc, "$[0].id");
    }


    public int callCreatePurchase(CommandPurchase commandPurchase) throws Exception {
        int tripId = callCreateTrip();
        commandPurchase = commandPurchaseDataBuilder.buildWithTripId(commandPurchase,tripId);
        mockMvc.perform(post("/api/purchase/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandPurchase)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/api/purchase/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        return JsonPath.read(mvc, "$[0].id");
    }
}
