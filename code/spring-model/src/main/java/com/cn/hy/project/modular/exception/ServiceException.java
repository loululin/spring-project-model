package com.cn.hy.project.modular.exception;

/**
 * <p>Title: ServiceException </p>
 * <p>Description: TODO </p>
 * Date: 2018年4月25日 上午10:31:33
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年4月25日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class ServiceException extends BaseException {

	/**
	 * Fields serialVersionUID: TODO(用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p> 
	 * @param errorCode
	 * @param errorMsg
	 */
	public ServiceException(int errorCode, String errorMsg) {  
		super(errorCode, errorMsg);  
	}  
	/**
	 * 
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p> 
	 * @param errorMsg
	 */
	public ServiceException(String errorMsg) {  
		super(errorMsg);  
	}  
	/**
	 * 
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p> 
	 * @param cause
	 * @param errorCode
	 * @param errorMsg
	 * @param traceId
	 */
	public ServiceException(Throwable cause, int errorCode, String errorMsg,  
			String traceId) {  
		super(cause, errorCode, errorMsg, traceId);  
	}  
	/**
	 * 
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p> 
	 * @param cause
	 * @param errorCode
	 * @param errorMsg
	 */
	public ServiceException(Throwable cause, int errorCode, String errorMsg) {  
		super(cause, errorCode, errorMsg);  
	}  
	/**
	 * 
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p> 
	 * @param cause
	 * @param errorMsg
	 */
	public ServiceException(Throwable cause, String errorMsg) {  
		super(cause, errorMsg);  
	}  
	/**
	 * 
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p> 
	 * @param cause
	 */
	public ServiceException(Throwable cause) {  
		super(cause);  
	}  

}
