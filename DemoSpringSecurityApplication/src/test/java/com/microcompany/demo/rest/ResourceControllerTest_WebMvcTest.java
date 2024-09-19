package com.microcompany.demo.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ResourceController.class)
class ResourceControllerTest_WebMvcTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser("juan")
    public void getResource() throws Exception {
        MvcResult result = mockMvc.perform(get("/resource").accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string("This is the resource"))
                .andReturn();
    }

}