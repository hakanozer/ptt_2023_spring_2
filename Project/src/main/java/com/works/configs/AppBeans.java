package com.works.configs;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class AppBeans {

    @Bean(name = "rt1")
    public RestTemplate restTemplate_1() {
        System.out.println("This line call");
        return new RestTemplate();
    }

    @Bean(name = "rt2")
    public RestTemplate restTemplate_2() {
        System.out.println("This line call");
        return new RestTemplate();
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(
                Arrays.asList(
                  new ConcurrentMapCache("product"),
                  new ConcurrentMapCache("customer")
                )
        );
        return cacheManager;
    }

}
