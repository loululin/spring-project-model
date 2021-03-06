package com.cn.hy.project.modular.service;

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

import com.cn.hy.project.modular.service.IUserService;
import com.cn.hy.project.modular.util.Constants;

/**
 * <p>Title: LdrkZhuYeSubMapperTest </p>
 * <p>Description: TODO </p>
 * Date: 2016年8月15日 上午11:18:42
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2016年8月15日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
@WebAppConfiguration
public class UserServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private IUserService userService;
	
	
	@Test
	public void getUsersTest(){
		List<Map<String, Object>> result = userService.getAllUsers();
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getAllUsers IS :   ---"  + Constants.COMM_GSON.toJson(result));
	}
	
	@Test
	public void getAllUsersWithPageHelperTest(){
		Map<String, Object> result = userService.getAllUsersWithPageHelper(2,3);
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getAllUsersWithPageHelper IS :   ---"  + Constants.COMM_GSON.toJson(result));
	}
	
	

}
