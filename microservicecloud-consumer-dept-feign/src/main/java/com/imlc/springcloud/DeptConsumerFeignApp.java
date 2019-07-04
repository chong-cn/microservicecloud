package com.imlc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 *
 * @Auther: L.C
 * @Date: 2019-07-02 11:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.imlc.springcloud"})
@ComponentScan("com.imlc.springcloud")
public class DeptConsumerFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeignApp.class, args);
    }

}

