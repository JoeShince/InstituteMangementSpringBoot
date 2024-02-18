package com.sample.institutemanagement;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.sample.institutemanagement.models.Institute;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringRunner.class)
public class TestWebApp extends InstituteManagementApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private static ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testEmployee() throws Exception {
        Institute institute = new Institute("abc institute","test","9476080802");
        String a = mapper.writeValueAsString(institute);

        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        MvcResult mvcResult = mockMvc.perform(post("/institute")
                        .content(a)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header("X-API-KEY","Institute"))
                .andExpect(status().isOk())
               .andReturn();
        String instituteId = JsonPath.read(mvcResult.getResponse().getContentAsString(),"$.id");;
        mockMvc.perform(get("/institute/"+ instituteId).header("X-API-KEY","Institute"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("abc institute"));
    }

}