package com.cn.hy.project.modular.dao;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cn.hy.project.modular.dao.UserMapper;
import com.cn.hy.project.modular.util.Constants;

/**
* @Description  用户操作测试类
* @Author LouLvLin
* @Date  2019/1/17  18:16
* @Param 
* @return 
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
@WebAppConfiguration
public class UserMapperTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper userMapper;
	
	
	@Test
	public void getUsersTest(){
		List<Map<String, Object>> result = userMapper.getUsers();
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getUsersTest IS :   ---"  + Constants.COMM_GSON.toJson(result));
	}
	
	

}
