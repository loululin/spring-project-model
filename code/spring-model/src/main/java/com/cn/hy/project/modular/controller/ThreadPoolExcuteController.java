package com.cn.hy.project.modular.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.hy.project.modular.util.RestUrlConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @Description  ThreadPoolExcuteController
* @Author LouLvLin
* @Date  2019/1/17  18:17
* @Param 
* @return 
**/
@RestController
@Api(tags="spring线程池")
public class ThreadPoolExcuteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExcuteController.class);
	
	@Autowired 
	private ThreadPoolTaskExecutor threadPool;
	
	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @return
	 */
	@ApiOperation(value="测试spring线程池", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.TEST_EXECUTOR_POOL, method = RequestMethod.GET)
	public void execute() {
		threadPool.execute(new Runnable() {
			
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				try {
					LOGGER.info("执行线程任务开始前");
                    Thread.currentThread().sleep(10000);
                    if (LOGGER.isDebugEnabled()) {
                    	LOGGER.info("执行线程任务结束");
                    }
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage(),e);
                }
				
			}
		});
	}
}
