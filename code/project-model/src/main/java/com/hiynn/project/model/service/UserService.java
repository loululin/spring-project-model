package com.hiynn.project.model.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiynn.project.model.dao.UserMapper;
import com.hiynn.project.model.util.Constants;

/**
 * <p>Title: UserService </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午2:13:01
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @return
	 */
	public Map<String, Object> getAllUsers(){
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			response.put("code", Constants.CODE_SUCCESS);
			response.put("msg", Constants.MSG_SUCCESS);
			response.put("result", userMapper.getUsers());
		} catch (Exception e) {
			LOGGER.error("获取所有用户 异常", e);
			response.put("code", Constants.CODE_FALSE);
			response.put("msg", Constants.MSG_FALSE);
		}
		LOGGER.debug("UserController.getResult() response is  :  " + Constants.COMM_GSON.toJson(response));
		return response;
	}
	
	
	

}
