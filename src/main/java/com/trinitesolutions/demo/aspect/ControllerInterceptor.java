/*
 * Copyright (c) 2017.  TJ
 */

package com.trinitesolutions.demo.aspect;

import com.trinitesolutions.demo.exception.NormalException;
import com.trinitesolutions.demo.vo.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
public class ControllerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);
    public static final String DEFAULT_ERROR_VIEW = "error";

    @Pointcut("execution(* com.trinitesolutions.demo.controller.*.*(..))")
    public void controlService(){}
    /*
     * 通过连接点切入
     */
    @Before(value = "controlService()")
    public void beforeProcess(){

    }

    @After(value = "controlService()")
    public void afterProcess(){

    }

    @Around(value = "controlService()")
    public Object aroundProcess(ProceedingJoinPoint thisJoinPoint) throws Throwable {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> params = request.getParameterNames();
            while(params.hasMoreElements()) {
                String name = params.nextElement();
                logger.info("param name >> " + name + "  value >> " + request.getParameter(name));
            }
            //url
            logger.info("url={}",request.getRequestURL());
            //method
            logger.info("method={}",request.getMethod());
            //ip
            logger.info("id={}",request.getRemoteAddr());
            //class_method
            logger.info("class_method={}",thisJoinPoint.getSignature().getDeclaringTypeName() + "," + thisJoinPoint.getSignature().getName());
            //args[]
            logger.info("args={}",thisJoinPoint.getArgs());
            return thisJoinPoint.proceed ();
    }

}