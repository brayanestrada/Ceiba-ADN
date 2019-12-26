package com.ventas.ventadepasajes.infrastructure.controller.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandDriver;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandDriverDataBuilder;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerListDriver {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandDriverDataBuilder commandDriverDataBuilder = new CommandDriverDataBuilder();

    private CommandDriver commandDriver;

    private String uriDriverCreate = "/driver/create";
    private String uriDriverList = "/driver/list";

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void listSuccessful() throws Exception {
        commandDriver = commandDriverDataBuilder.build();
        callRequestCreateDriver(commandDriver);
        assertTrue(validateCreatedDriver());
    }

    private String callRequestListDriver() throws Exception {
        MvcResult result = mockMvc.perform(get(uriDriverList)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return result.getResponse().getContentAsString();
    }

    private boolean validateCreatedDriver() throws Exception {
        String result = callRequestListDriver();
        assertEquals(JsonPath.read(result, "$[0].name"), commandDriverDataBuilder.getName());
        assertEquals(JsonPath.read(result, "$[0].lastName"), commandDriverDataBuilder.getLastName());
        assertEquals(JsonPath.read(result, "$[0].identification"), commandDriverDataBuilder.getIdentification());
        return true;
    }

    private void callRequestCreateDriver(CommandDriver commandDriver) throws Exception {
        mockMvc.perform(post(uriDriverCreate)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandDriver)))
                .andExpect(status().isCreated());
    }

}
