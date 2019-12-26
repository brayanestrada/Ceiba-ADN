package com.ventas.ventadepasajes.infrastructure.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandRole;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandUser;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandRoleDataBuilder;
import com.ventas.ventadepasajes.infrastructure.testdatabuilder.CommandUserDataBuilder;
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

import static com.ventas.ventadepasajes.infrastructure.controller.user.Utils.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerCreateUser {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private String uri = "/user/create";

    private CommandUserDataBuilder commandUserDataBuilder = new CommandUserDataBuilder();

    private CommandUser commandUser;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void createUser() throws Exception {
        this.commandUser = commandUserDataBuilder.build();
        assertTrue(callRequestCreateUser(commandUser));
    }

    @Test
    public void createUserWithoutName() throws Exception {
        this.commandUser = commandUserDataBuilder.buildWithoutName();
        assertTrue(callRequestCreateBadUser(commandUser, NAME_IS_MANDATORY));
    }

    @Test
    public void createUserWithoutLastName() throws Exception {
        this.commandUser = commandUserDataBuilder.buildWithoutLastName();
        assertTrue(callRequestCreateBadUser(commandUser, LAST_NAME_IS_MANDATORY));
    }

    @Test
    public void createUserWithoutEmail() throws Exception {
        this.commandUser = commandUserDataBuilder.buildWithoutEmail();
        assertTrue(callRequestCreateBadUser(commandUser, EMAIL_IS_MANDATORY));
    }

    @Test
    public void createUserWithoutPhone() throws Exception {
        this.commandUser = commandUserDataBuilder.buildWithoutPhone();
        assertTrue(callRequestCreateBadUser(commandUser, PHONE_IS_MANDATORY));
    }

    @Test
    public void createUserWithoutRole() throws Exception {
        this.commandUser = commandUserDataBuilder.buildWithoutRole();
        assertTrue(callRequestCreateBadUserWithoutRoleId(commandUser, ROLE_ID_IS_MANDATORY));
    }

    @Test
    public void createUserWithoutPassword() throws Exception {
        this.commandUser = commandUserDataBuilder.buildWithoutPassword();
        assertTrue(callRequestCreateBadUser(commandUser, PASS_IS_MANDATORY));
    }

    @Test
    public void createUserLongName() throws Exception {
        this.commandUser = commandUserDataBuilder.buildLongName();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_NAME_MAX_LENGTH));
    }

    @Test
    public void createUserLongLastName() throws Exception {
        this.commandUser = commandUserDataBuilder.buildLongLastName();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_LAST_NAME_MAX_LENGTH));
    }

    @Test
    public void createUserLongPhone() throws Exception {
        this.commandUser = commandUserDataBuilder.buildLongPhone();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_PHONE_MAX_LENGTH));
    }

    @Test
    public void createUserLongPassword() throws Exception {
        this.commandUser = commandUserDataBuilder.buildLongPassword();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_PASS_MAX_LENGTH));
    }


    @Test
    public void createUserSmallName() throws Exception {
        this.commandUser = commandUserDataBuilder.buildSmallName();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_NAME_MIN_LENGTH));
    }

    @Test
    public void createUserSmallLastName() throws Exception {
        this.commandUser = commandUserDataBuilder.buildSmallLastName();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_LAST_NAME_MIN_LENGTH));
    }

    @Test
    public void createUserSmallPhone() throws Exception {
        this.commandUser = commandUserDataBuilder.buildSmallPhone();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_PHONE_MIN_LENGTH));
    }

    @Test
    public void createUserSmallPassword() throws Exception {
        this.commandUser = commandUserDataBuilder.buildSmallPassword();
        assertTrue(callRequestCreateBadUser(commandUser, ERROR_PASS_MIN_LENGTH));
    }

    public int callCreateRole() throws Exception {
        CommandRoleDataBuilder commandRoleDataBuilder = new CommandRoleDataBuilder();
        CommandRole commandRole = commandRoleDataBuilder.build();
        mockMvc.perform(post("/role/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandRole)))
                .andExpect(status().isCreated());

        MvcResult mvcResult  = mockMvc.perform(get("/role/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String mvc = mvcResult.getResponse().getContentAsString();
        System.out.println(mvc);
        return JsonPath.read(mvc, "$[0].id");
    }

    public Boolean callRequestCreateUser(CommandUser commandUser) throws Exception {
        int id = callCreateRole();
        commandUser = commandUserDataBuilder.buildWithRoleId(commandUser, id);
        mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandUser)))
                .andExpect(status().isCreated());
        return true;
    }

    public Boolean callRequestCreateBadUser(CommandUser commandUser, String message) throws Exception {
        int id = callCreateRole();
        commandUser = commandUserDataBuilder.buildWithRoleId(commandUser, id);
        MvcResult mvcResult = mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandUser)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
        return true;
    }

    public Boolean callRequestCreateBadUserWithoutRoleId(CommandUser commandUser, String message) throws Exception {
        commandUser = commandUserDataBuilder.buildWithRoleId(commandUser, 0);
        MvcResult mvcResult = mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandUser)))
                .andExpect(status().isBadRequest())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        if (!result.contains(message)){
            Assert.fail("Should throw bad request exception but it didn't happen");
        }
        return true;
    }
}
