package com.imlc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 11:50
 */
@Configuration
public class RestTemplateConfig {

    /**
     * SpringCloud Ribbon是基于Netflix Ribbon实现的一套"客户端"负载均衡的工具。
     * 理解：由客户端选择使用那个服务
     * 场景：商场结账时，用户自动选择人少的窗口排队结账
     *
     * @Author: L.C
     * @Date: 2019-07-03 17:03
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // ms
        factory.setReadTimeout(5000);
        // ms
        factory.setConnectTimeout(5000);
        return factory;
    }


}
