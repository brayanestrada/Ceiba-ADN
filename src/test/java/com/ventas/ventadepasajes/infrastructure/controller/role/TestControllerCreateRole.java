package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandRoleDataBuilder;
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

import static com.ventas.ventadepasajes.infrastructure.controller.role.Utils.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerCreateRole {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandRoleDataBuilder commandRoleDataBuilder = new CommandRoleDataBuilder();

    private CommandRole commandRole;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void createRole() throws Exception {
        this.commandRole = commandRoleDataBuilder.build();
        callRequestCreateDriver(commandRole);
    }

    @Test
    public void createRoleSmallName() throws Exception {
        this.commandRole = commandRoleDataBuilder.buildSmallName();
        callRequestCreateBadDriver(commandRole, ERROR_NAME_LENGTH);
    }

    @Test
    public void createRoleWithoutName() throws Exception {
        this.commandRole = commandRoleDataBuilder.buildWithoutName();
        callRequestCreateBadDriver(commandRole, ERROR_NAME_MANDATORY);
    }

    @Test
    public void createRoleLongName() throws Exception{
        this.commandRole = commandRoleDataBuilder.buildLongName();
        callRequestCreateBadDriver(commandRole, ERROR_NAME_LENGTH);
    }


    private void callRequestCreateDriver(CommandRole commandRole) throws Exception {
        mockMvc.perform(post("/api/role/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandRole)))
                .andExpect(status().isCreated());
    }

    private void callRequestCreateBadDriver(CommandRole commandRole, String message) throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/role/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandRole)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
    }
}
