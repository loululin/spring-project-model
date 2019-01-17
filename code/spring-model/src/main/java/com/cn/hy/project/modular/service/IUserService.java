package com.cn.hy.project.modular.service;

import java.util.List;
import java.util.Map;

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
public interface IUserService {
	
	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @return
	 */
	List<Map<String, Object>> getAllUsers();
	
	/**
	 * <p>Title: getUsersWithOutCache </p>
	 * <p>Description: 获取所有用户,不走ehcache缓存 </p>
	 * @return
	 */
	List<Map<String, Object>> getUsersWithOutCache();
	
	/**
	 * <p>Title: getAllUsersWithPageHelper </p>
	 * <p>Description: 分页获取用户信息  </p>
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> getAllUsersWithPageHelper(int currentPage, int pageSize);
	/**
	 * <p>Title: getDivisionResult </p>
	 * <p>Description: 获取除法结果 </p>
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	Integer getDivisionResult(int numerator, int denominator);
	

}
