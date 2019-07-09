package com.imlc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * HystrixDashBoard 支持
 *
 * @Auther: L.C
 * @Date: 2019-07-09 17:51
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashBoardApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashBoardApp.class, args);
    }

}
