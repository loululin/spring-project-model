package com.cn.hy.project.modular.util;

/**
 * <p>Title: RestUrlConstants </p>
 * <p>Description: TODO </p>
 * Date: 2018年4月25日 下午4:24:02
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年4月25日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class RestUrlConstants {
	
	/**
	 * <p>Title: LangChaoRestURIConstants </p>
	 * <p>Description: Constructor </p>  
	 */
	private RestUrlConstants() {
	}


	/**
	 * 获取所有用户
	 */
	public static final String ALL_USERS = "/users/all";
	/**
	 * 获取所有用户,不走ehcache缓存
	 */
	public static final String ALL_USERS_NO_CACHE = "/users/all/nochache";
	/**
	 * 分页获取用户信息
	 */
	public static final String GET_USERS_WITH_PAGE = "/users/{currentPage}/{pageSize}";
	/**
	 * 测试serviceException
	 */
	public static final String TEST_SERVICE_EXCEPTION = "/test/serviceException";
	/**
	 * 测试非serviceException
	 */
	public static final String TEST_OTHER_EXCEPTION = "/test/otherException/{numerator}/{denominator}";
	/**
	 * 测试spring线程池
	 */
	public static final String TEST_EXECUTOR_POOL = "/execute";

}
