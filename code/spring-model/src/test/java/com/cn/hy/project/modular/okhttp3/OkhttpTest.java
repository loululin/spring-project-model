package com.cn.hy.project.modular.okhttp3;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cn.hy.project.modular.okhttp3.OkHttpUtil;

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
public class OkhttpTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(OkhttpTest.class);

	@Test
	public void getStringFromServerTest(){
		String getResult = OkHttpUtil.getStringFromServer("https://www.baidu.com/");
		LOGGER.info("中文测试");
		Assert.assertThat(getResult, Matchers.containsString("STATUS OK"));
	}
	
	

}
