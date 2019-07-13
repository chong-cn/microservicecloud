package com.aolc.springcloud;

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
@EnableFeignClients(basePackages = {"com.aolc.springcloud"})
@ComponentScan("com.aolc.springcloud")
public class ConsumerFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApp.class, args);
    }

}

