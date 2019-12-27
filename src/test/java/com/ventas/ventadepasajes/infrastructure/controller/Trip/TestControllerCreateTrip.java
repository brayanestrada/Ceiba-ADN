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

import static com.ventas.ventadepasajes.infrastructure.controller.Trip.Utils.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerCreateTrip {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private String uri = "/trip/create";
    private CommandTripDataBuilder commandTripDataBuilder = new CommandTripDataBuilder();
    private CommandTrip commandTrip;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void createTrip() throws Exception {
        this.commandTrip = commandTripDataBuilder.build();
        assertTrue(callRequestCreateTrip(commandTrip));
    }

    @Test
    public void createBadTripWithoutSeatsAvailable() throws Exception {
        this.commandTrip = commandTripDataBuilder.buildWithoutSeatsAvailable();
        assertTrue(callRequestCreateBadTrip(commandTrip, ERROR_MANDATORY_SEATS_AVAILABLE));
    }

    @Test
    public void createBadTripWithoutStartCity() throws Exception {
        this.commandTrip = commandTripDataBuilder.buildWithoutStartCity();
        assertTrue(callRequestCreateBadTrip(commandTrip, ERROR_START_CITY_MANDATORY));
    }

    @Test
    public void createBadTripWithoutEndCity() throws Exception {
        this.commandTrip = commandTripDataBuilder.buildWithoutEndCity();
        assertTrue(callRequestCreateBadTrip(commandTrip, ERROR_END_CITY_MANDATORY));
    }

    @Test
    public void createBadTripWithoutIdDriver() throws Exception {
        this.commandTrip = commandTripDataBuilder.buildWithoutIdDriver();
        assertTrue(callRequestCreateTripWithoutDriverId(commandTrip)); }

    @Test
    public void createBadTripMinValueSeatsAvailable() throws Exception {
        this.commandTrip = commandTripDataBuilder.buildMinValueSeatsAvailable();
        assertTrue(callRequestCreateBadTrip(commandTrip, ERROR_MIN_SEATS_AVAILABLE));
    }

    @Test
    public void createBadTripBadDateFormat() throws Exception {
        this.commandTrip = commandTripDataBuilder.buildBadDateFormat();
        assertTrue(callRequestCreateBadTrip(commandTrip, ERROR_DATE_FORMAT));
    }

    private int callRequestCreateDriver() throws Exception {
        CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();
        CommandDriver commandDriver = commandDriverDataBuilder.build();
        mockMvc.perform(post("/driver/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDriver)))
                .andExpect(status().isCreated());
        MvcResult mvcResult  = mockMvc.perform(get("/driver/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        System.out.println(mvc);
        return JsonPath.read(mvc, "$[0].id");
    }


    private Boolean callRequestCreateTrip(CommandTrip commandTrip) throws Exception {
        int driverId = callRequestCreateDriver();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, driverId);
        mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isCreated());

        return true;
    }

    private Boolean callRequestCreateBadTrip(CommandTrip commandTrip, String message) throws Exception {
        int idDriver = callRequestCreateDriver();
        commandTrip = commandTripDataBuilder.buildWithDriverId(commandTrip, idDriver);
        MvcResult mvcResult = mockMvc.perform(post(uri)
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

    private Boolean callRequestCreateTripWithoutDriverId(CommandTrip commandTrip) throws Exception {
        callRequestCreateDriver();
        MvcResult mvcResult = mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandTrip)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(Utils.ERROR_ID_DRIVER_MANDATORY)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
        return true;
    }
}
