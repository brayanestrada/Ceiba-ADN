package com.ventas.ventadepasajes.infrastructure.controller.role;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandRoleDataBuilder;
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

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerDeleteRole {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private CommandRoleDataBuilder commandRoleDataBuilder = new CommandRoleDataBuilder();

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void deleteRole() throws Exception {
        CommandRole commandRole = commandRoleDataBuilder.build();
        int id = callCreateRole(commandRole);
        callDeleteRole(id);
        if(!callRequestListRole().contains("[]")){
            fail("Error, the record wasn't deleted");
        }
    }

    private int callCreateRole(CommandRole commandRole) throws Exception {
        mockMvc.perform(post("/api/role/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandRole)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/api/role/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        return JsonPath.read(mvc, "$[0].id");
    }

    private void callDeleteRole(int id) throws Exception {
        mockMvc.perform(delete("/api/role/delete/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private String callRequestListRole() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/role/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        return result.getResponse().getContentAsString();
    }
}
