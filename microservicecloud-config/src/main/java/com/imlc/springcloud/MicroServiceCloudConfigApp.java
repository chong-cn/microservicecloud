package com.imlc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: L.C
 * @Date: 2019-07-11 12:40
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class MicroServiceCloudConfigApp {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudConfigApp.class, args);
    }

}
