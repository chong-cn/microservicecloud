package com.imlc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul路由和网关
 *
 * @Auther: L.C
 * @Date: 2019-07-10 14:23
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulStartSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulStartSpringCloudApp.class, args);
    }

}
