package com.aolc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务端启动类，接受其他微服务注册
 *
 * @Auther: L.C
 * @Date: 2019-07-02 14:26
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp_01 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp_01.class, args);
    }

}
