package com.imlc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 11:51
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApp.class, args);
    }

}
