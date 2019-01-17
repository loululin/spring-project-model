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
