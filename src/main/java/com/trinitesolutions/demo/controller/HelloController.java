/*
 * Copyright (c) 2017.  TJ
 */

package com.trinitesolutions.demo.controller;


import com.trinitesolutions.demo.exception.NormalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String index() {
        logger.info("visit");
        return "it works";
    }

    @GetMapping("/hi/{content}")
    public String hi(@PathVariable String content) {
        logger.info(content);
        return "hi "+ content;
    }

    @GetMapping("/hi2")
    public String hi2( String content2) throws Exception{
        logger.info(content2);
        if(content2.equals("12")) {
            throw new NormalException(1, "haha err...");
        }
        return "hi "+ content2;
    }
}
