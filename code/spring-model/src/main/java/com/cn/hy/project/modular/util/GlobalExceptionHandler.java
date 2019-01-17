package com.cn.hy.project.modular.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cn.hy.project.modular.entity.ResultBuilder;
import com.cn.hy.project.modular.exception.BaseException;

/**
 * 
 * <p>Title: GlobalExceptionHandler </p>
 * <p>Description: controller层统一异常处理 </p>
 * Date: 2017年7月13日 下午4:33:36
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月13日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResultBuilder handleException(Exception ex) {
		LOGGER.error("spring统一异常处理捕获Controller层异常： ", ex);
		return (ex instanceof BaseException) ? ResultBuilder.fail().build(Constants.MSG_BASE_EXCEPTION + ex.getMessage())
				: ResultBuilder.fail().build(Constants.MSG_OTHER_EXCEPTION + ex.getMessage());
	}
}
