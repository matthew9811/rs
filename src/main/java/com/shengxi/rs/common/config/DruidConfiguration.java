package com.shengxi.rs.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.shengxi.system.common.constant.DataSourceType;
import com.shengxi.system.entity.config.DruidProperties;
import com.shengxi.rs.common.handler.DynamicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Matthew
 * @Date: 2019/3/14 19:11
 * @Description: 连接池配置
 * 实现主从库配置（主库读，从库写。提高效率）
 */
@Configuration
@EnableTransactionManagement
public class DruidConfiguration {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.master", name = "enabled", havingValue = "true")
    public DataSource masterDataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(DataSourceType.values().length);
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
        targetDataSources.put(DataSourceType.SLAVE.name(), slaveDataSource);
        logger.info(">>>>>>>>DruidConfiguration>>>>>>>>>>   {}", targetDataSources.toString());
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }


}
