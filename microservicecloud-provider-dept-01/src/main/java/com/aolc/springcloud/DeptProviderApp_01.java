package com.aolc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  将服务启动后自动注册进Eureka服务
 *
 * @Auther: L.C
 * @Date: 2019-07-02 10:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProviderApp_01 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApp_01.class, args);
    }

    /*
      @EnableDiscoveryClient与@EnableEurekaClient
        共同点：均可让注册中心发现，扫描到该服务。
        不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient可以是其他注册中心。
      总结：如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
     */
}
