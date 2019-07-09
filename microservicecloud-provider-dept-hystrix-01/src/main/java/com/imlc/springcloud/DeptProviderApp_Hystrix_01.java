package com.imlc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  Hystrix熔断机制支持
 *
 * @Auther: L.C
 * @Date: 2019-07-02 10:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DeptProviderApp_Hystrix_01 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApp_Hystrix_01.class, args);
    }


}
