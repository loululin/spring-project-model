package com.hiynn.project.model.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hiynn.project.model.service.UserService;
import com.hiynn.project.model.util.RestURIConstants;

/**
 * 
 * <p>Title: UserController </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月19日 下午2:20:31
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月19日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @param session
	 * @return
	 */
	@RequestMapping(value = RestURIConstants.ALL_USERS, method = RequestMethod.GET)
	public Map<String, Object> getAllUsers() {
		return userService.getAllUsers();
	}

}
