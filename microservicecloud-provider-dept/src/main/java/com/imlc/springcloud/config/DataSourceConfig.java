package com.imlc.springcloud.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 10:29
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig extends HikariConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean(name = "primaryDataSource", destroyMethod = "close")
    @Primary
    @Qualifier("primaryDataSource")
    public DataSource primaryDataSource() {
        logger.info("数据源连接： 成功");

        return new HikariDataSource(this);


    }

}

