//package com.glanse.microservices.service.web.controller;
//
//import com.glanse.microservices.service.gateway.config.WebSecurityConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(MainController.class)
//@Import(WebSecurityConfig.class)
//@TestPropertySource(properties={
//        "eureka.client.enabled=false",
//        "spring.application.name=WebServiceTest",
//        "spring.jmx.default-domain=WebServiceTest"})
//public class MainControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void contextLoads() {}
//
//    @Test
//    public void indexATest() throws Exception {
//        this.mockMvc.perform(get("/dashboard"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Glanse Dashboard")));
//    }
//}
