package com.aolc.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 配置Bean
 *
 * @Auther: L.C
 * @Date: 2019-07-02 11:50
 */
@Configuration
public class ConfigBean {

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

    /**
     * Ribbon负载均衡-算法（默认使用轮询算法）
     *
     * @Author: L.C
     * @Date: 2019-07-04 11:01
     */
    @Bean
    public IRule myRule() {
        /**
         * 轮询算法: RoundRobinRule
         * 随机算法: RandomRule
         * 重试算法：RetryRule，微服务正常情况下与轮询算法效果一样，若故障，轮询多次仍故障时过滤掉故障服务
         *
         *
         * @Author: L.C
         * @Date: 2019-07-04 11:05
         */
        return new RetryRule();


    }


}
