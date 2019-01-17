package com.cn.hy.project.modular.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cn.hy.project.modular.util.RestUrlConstants;

/**
 * <p>Title: UserControllerTest </p>
 * <p>Description: TODO </p>
 * Date: 2018年2月5日 下午4:24:48
 * @author hp@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年2月5日         hp         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mvc.xml"})
@Transactional(transactionManager = "transactionManager",rollbackFor=Exception.class)
@Rollback(value=true)
@WebAppConfiguration
public class UserControllerTest {
	
	
	@Autowired  
    private WebApplicationContext webApplicationContext ;  
      
    private MockMvc mockMvc ;  
      
    @Before  
    public void setUp() throws Exception  
    {  
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();  
    } 
    
    @Test
    public void getUsersWithPageTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/3").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andDo(MockMvcResultHandlers.print())
        .andReturn();
    }
    
    @Test
    public void getAllUsersTest() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get(RestUrlConstants.ALL_USERS).accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andDo(MockMvcResultHandlers.print())
        .andReturn();
    }

}
