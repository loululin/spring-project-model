package com.cn.hy.project.modular.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * <p>Title: BaseException </p>
 * <p>Description: TODO </p>
 * Date: 2018年4月24日 下午6:27:00
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2018年4月24日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class BaseException extends RuntimeException {

	/**
	 * Fields serialVersionUID: TODO(用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
     * 未知错误code 
     */  
    public static final int UNKNOWN_ERROR_CODE = 3;  
    /**
     * 异常
     */
    private Throwable cause;
    /**
     * 错误code
     */
    private int errorCode;
    /**
     * 追踪id
     */
    private String traceId;  
      
    /**
     * <p>Title: BaseException </p>
     * <p>Description: Constructor </p> 
     * @param errorMsg
     */
    public BaseException(String errorMsg){  
        this(null, errorMsg);  
    }  
    /**
     * <p>Title: BaseException </p>
     * <p>Description: Constructor </p> 
     * @param cause
     */
    public BaseException(Throwable cause){  
        this(cause, "");  
    }  
    /**
     * <p>Title: BaseException </p>
     * <p>Description: Constructor </p> 
     * @param errorCode
     * @param errorMsg
     */
    public BaseException(int errorCode, String errorMsg) {  
        this(null, errorCode, errorMsg);  
    }  
    
    /**
     * <p>Title: BaseException </p>
     * <p>Description: Constructor </p> 
     * @param cause
     * @param errorMsg
     */
    public BaseException(Throwable cause, String errorMsg){  
        this(cause, BaseException.UNKNOWN_ERROR_CODE, errorMsg);  
    }  
    /**
     * <p>Title: BaseException </p>
     * <p>Description: Constructor </p> 
     * @param cause
     * @param errorCode
     * @param errorMsg
     */
    public BaseException(Throwable cause, int errorCode, String errorMsg){  
        this(cause, errorCode, errorMsg, null);  
    }  
    /**
     * <p>Title: BaseException </p>
     * <p>Description: Constructor </p> 
     * @param cause
     * @param errorCode
     * @param errorMsg
     * @param traceId
     */
    public BaseException(Throwable cause, int errorCode, String errorMsg, String traceId){  
        super(errorMsg);  
        this.cause = cause;  
        this.errorCode = errorCode;  
        this.traceId = traceId;  
    }
    
    /**
     *   
     */
    @Override
    public void printStackTrace() {  
        this.printStackTrace(System.err);  
    }  
    /**
     *   
     */
    @Override
    public void printStackTrace(PrintStream ps){  
        if(null == getCause()){  
            super.printStackTrace(ps);  
        }else{  
            ps.println(this);  
            getCause().printStackTrace(ps);  
        }  
    }  
    /**
     *   
     */
    @Override
    public void printStackTrace(PrintWriter pw){  
        if(null == getCause()){  
            super.printStackTrace(pw);  
        }else{  
            pw.println(this);  
            getCause().printStackTrace(pw);  
        }  
    }  
    /**
     *   
     */
    @Override
    public Throwable getCause(){  
        return this.cause == this ? null : this.cause;  
    }  
    
    /**
     * 
     */
    @Override
    public String getMessage(){  
        if (getCause() == null) {  
            return super.getMessage();  
        }  
        return super.getMessage() + getCause().getMessage();  
    }  
    /**
     * <p>Title: getErrorCode </p>
     * <p>Description: TODO </p>
     * @return
     */
    public int getErrorCode() {  
        return errorCode;  
    }  
    /**
     * <p>Title: getTraceId </p>
     * <p>Description: TODO </p>
     * @return
     */
    public String getTraceId() {  
        return traceId;  
    } 

}
