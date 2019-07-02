package com.imlc.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 11:50
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public org.springframework.web.client.RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new org.springframework.web.client.RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);// ms
        factory.setConnectTimeout(5000);// ms
        return factory;
    }
}
