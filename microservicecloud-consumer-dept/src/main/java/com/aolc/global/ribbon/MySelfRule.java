package com.aolc.global.ribbon;

import com.netflix.loadbalancer.IRule;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 警告：
 * 自定义配置类不能放在@ComponentScan所扫描的当前包及自包下，
 * 否则自定义的此配置类就会被所有的Ribbon客户端所共享，
 * 从而达不到特殊化定制的目的，
 *
 * @Auther: L.C
 * @Date: 2019-07-04 11:34
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 默认是轮询算法，此处自定义为自定义随机算法
        return new CustomRandomRule();
    }
}
