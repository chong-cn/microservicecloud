package com.imlc.springcloud.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.imlc.springcloud.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class PrimaryDataSouceConfig {

    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //mybatis.configuration.mapUnderscoreToCamelCase=true
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        Properties properties = new Properties();
        properties.setProperty("zeroDateTimeBehavior", "convertToNull");
        configuration.setVariables(properties);
        sqlSessionFactoryBean.setConfiguration(configuration);
        // 设置查找器
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        return sqlSessionFactoryBean.getObject();

    }

    @Bean(name = "mysqlTransactionManagement")
    public PlatformTransactionManager mysqlTransactionManagement() {
        return new DataSourceTransactionManager(primaryDataSource);
    }

}
