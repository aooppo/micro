package com.trinitesolutions.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ControllerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    @Pointcut("execution(* com.trinitesolutions.demo.controller.HelloController.*(..))")
    public void controlService(){}
    /*
     * 通过连接点切入
     */
    @Before(value = "controlService()")
    public void beforeProcess(){
        logger.info("execute in before");
    }

    @After(value = "controlService()")
    public void afterProcess(){
        logger.info("execute in after");
    }

    @Around(value = "controlService()")
    public Object aroundProcess(ProceedingJoinPoint thisJoinPoint){
        try {
            logger.info("around before process");
            return thisJoinPoint.proceed ();
        } catch (Throwable e) {
            e.printStackTrace ();
        }finally {
            logger.info("around after process");
        }
        return null;
    }

}