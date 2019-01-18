package com.cn.hy.project.modular.entity;

import java.io.Serializable;

import com.cn.hy.project.modular.util.Constants;

/**
* @Description  Result
* @Author LouLvLin
* @Date  2019/1/17  18:17
* @Param 
* @return 
**/
public class ResultBuilder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -602413775193033896L;
	private int code;
	private String msg;
	private Object result;
	
	/**
	 * <p>Title: Result </p>
	 * <p>Description: Constructor </p>
	 */
	private ResultBuilder() {
	}
	/**
	 * <p>Title: success </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public static ResultBuilder success() {
		ResultBuilder result = new ResultBuilder();
		result.code = Constants.CODE_SUCCESS;
		result.msg = Constants.MSG_SUCCESS;
		return result;
	}
	/**
	 * <p>Title: fail </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public static ResultBuilder fail() {
		ResultBuilder result = new ResultBuilder();
		result.code = Constants.CODE_FAIL;
		result.msg = Constants.MSG_FAIL;
		return result;
	}

	/**
	 * <p>Title: build </p>
	 * <p>Description: TODO </p>
	 * @param result
	 * @return
	 */
	public ResultBuilder build(Object result) {
		if (null != result) {
			this.result = result;
		} else {
			this.result = null;
		}
		return this;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Result{");
		sb.append(", 'code':'").append(code).append('\'');
		sb.append(", 'message':'").append(msg).append('\'');
		sb.append(", 'result':").append(result);
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Result.java
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Result.java
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Result.java
	 * @return the message
	 */
	public String getMessage() {
		return msg;
	}

	/**
	 * Result.java
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.msg = message;
	}

	/**
	 * Result.java
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Result.java
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
}
