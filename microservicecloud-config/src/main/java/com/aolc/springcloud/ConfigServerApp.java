package com.aolc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: L.C
 * @Date: 2019-07-11 12:40
 */
@SpringBootApplication
//@EnableConfigServer
public class ConfigServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp.class, args);
    }

}
