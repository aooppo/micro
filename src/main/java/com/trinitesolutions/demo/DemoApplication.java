/*
 * Copyright (c) 2017.  TJ
 */

package com.trinitesolutions.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
//@EnableWebMvc
//@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cm = new SimpleCacheManager();
	    List<Cache> cacheList = new ArrayList<>();
	    cacheList.add(new ConcurrentMapCache("person"));
	    cacheList.add(new ConcurrentMapCache("person2"));
	    cm.setCaches(cacheList);

	    return cm;
    }


}
