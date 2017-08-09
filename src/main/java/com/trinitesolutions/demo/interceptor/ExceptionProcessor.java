/*
 * Copyright (c) 2017.  TJ
 */

package com.trinitesolutions.demo.interceptor;

import com.trinitesolutions.demo.controller.PersonController;
import com.trinitesolutions.demo.exception.NormalException;
import com.trinitesolutions.demo.utils.ResultUtils;
import com.trinitesolutions.demo.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice("com.trinitesolutions")
public class ExceptionProcessor {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionProcessor.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class, NormalException.class})
    public Result<?> defaultErrorHandler(Exception e) throws Exception {
        if(e instanceof NormalException) {
            logger.error("Found an exception on " + e);
            NormalException ne = (NormalException) e;
            return ResultUtils.error(ne.getCode(), ne.getDetailMsg());
        }
        logger.info("e 222: "+e);
        return ResultUtils.error(-1, "unknown err : " + e.getMessage());
    }
}
