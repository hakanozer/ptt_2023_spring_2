package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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

}
