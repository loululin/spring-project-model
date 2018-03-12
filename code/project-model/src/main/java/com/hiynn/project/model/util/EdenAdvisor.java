package com.hiynn.project.model.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>Title: HiynnAdvisor </p>
 * <p>Description: TODO </p>
 * Date: 2017年7月13日 下午3:33:31
 * @author loulvlin@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月13日         loulvlin         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class EdenAdvisor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(EdenAdvisor.class);

    @SuppressWarnings("rawtypes")
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String flag = getMethodString(invocation);
        long start = System.currentTimeMillis();
        try {
            Object result = invocation.proceed();
            long cost = System.currentTimeMillis() - start;
            StringBuilder sb = new StringBuilder();
            sb.append("Executed " + flag + " [ timeCost -> " + cost + " ms , result(size) -> ");
            if (result instanceof List) {
                sb.append(((List) result).size());
            } else if (result instanceof Map) {
                sb.append(((Map) result).size());
            } else {
                sb.append(result);
            }
            sb.append(" ]");
            LOGGER.info(sb.toString());
            return result;
        } catch (Exception e) {
            //错误信息
            StringBuilder sb = new StringBuilder();
            sb.append("Executed " + flag + " [ timeCost -> " + (System.currentTimeMillis() - start) + " ms ] ");
            sb.append(e.getClass().getName() + ",");
            sb.append(e.toString());
            LOGGER.error(sb.toString());

            //执行时间
            StringBuilder sb1 = new StringBuilder();
            sb1.append("Executed " + flag + " [ timeCost -> " + (System.currentTimeMillis() - start) + " ms ] ");
            LOGGER.info(sb1.toString());

            throw e;
        } 

    }

    /**
     * <p>Title: getMethodString </p>
     * <p>Description: 获取MethodInvocation的输出文本 </p>
     * @param invocation
     * @return
     */
    private static String getMethodString(MethodInvocation invocation) {
        Method method = invocation.getMethod();
        StringBuilder sb = new StringBuilder();
        sb.append(method.getDeclaringClass().getSimpleName());
        sb.append("@[");
        sb.append(method.getReturnType().getSimpleName()).append(" ");
        sb.append(method.getName());
        sb.append("(");
        @SuppressWarnings("rawtypes")
        Class[] params = method.getParameterTypes();
        for (int j = 0; j < params.length; j++) {
            sb.append(params[j].getSimpleName());
            if (j < (params.length - 1)) {
                sb.append(",");
            }
        }
        sb.append(")]");
        return sb.toString();
    }
}
