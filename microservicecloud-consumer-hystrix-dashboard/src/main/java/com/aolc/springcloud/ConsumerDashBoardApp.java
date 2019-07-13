package com.aolc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * HystrixDashBoard 支持
 *
 * @Auther: L.C
 * @Date: 2019-07-09 17:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class ConsumerDashBoardApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDashBoardApp.class, args);
    }

}
