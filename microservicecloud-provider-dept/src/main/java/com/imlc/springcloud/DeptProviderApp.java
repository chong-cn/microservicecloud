package com.imlc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  将服务启动后自动注册进Eureka服务
 *
 * @Auther: L.C
 * @Date: 2019-07-02 10:13
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApp.class, args);
    }


}