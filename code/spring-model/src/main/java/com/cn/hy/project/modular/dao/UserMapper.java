package com.cn.hy.project.modular.dao;

import java.util.List;
import java.util.Map;

/**
* @Description  UserMapper
* @Author LouLvLin
* @Date  2019/1/17  18:17
* @Param 
* @return 
**/
public interface UserMapper {
	
	
	/**
	 * <p>Title: getUsers </p>
	 * <p>Description: 获取所有用户</p>
	 * @return
	 */
	List<Map<String, Object>> getUsers();
	
	/**
	 * <p>Title: getUsersWithOutCache </p>
	 * <p>Description: 获取所有用户,不走ehcache缓存</p>
	 * @return
	 */
	List<Map<String, Object>> getUsersWithOutCache();
	
}
