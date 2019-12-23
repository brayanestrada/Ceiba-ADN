package com.ventas.ventadepasajes.infrastructure.controller.trip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventas.ventadepasajes.VentadepasajesApplication;
import com.ventas.ventadepasajes.aplication.command.handler.command.CommandTrip;
import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
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
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VentadepasajesApplication.class)
@AutoConfigureMockMvc
public class TestControllerDeleteTrip {


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    private boolean callRequestedCreateTrip(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            CommandTripDataBuilder commandTripDataBuilder = new CommandTripDataBuilder();
            CommandTrip commandTrip = commandTripDataBuilder.build();
            mockMvc.perform(post("/trip/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(commandTrip)))
                    .andExpect(status().isCreated());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String callRequestDeleteTrip(long id) throws Exception {
        MvcResult mvcResult =  mockMvc.perform(delete("/trip/delete/"+id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        return mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void  deleteTrip() throws Exception {
        if(callRequestedCreateTrip()){
            callRequestDeleteTrip(1);
            if(callRequestedCreateTrip()){
                callRequestDeleteTrip(2);
            }else{
                throw new ExceptionGeneral("Error creating trip on delete trip test");
            }

        }else{
            throw new ExceptionGeneral("Error creating trip on delete trip test");
        }
    }
}
