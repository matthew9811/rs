package com.shengxi.rs.common.config;

import com.shengxi.rs.common.interceptor.SqlStatementInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Matthew
 * @Date: 2019/4/6 23:10
 * @Description:
 */
@Configuration
public class MybatisConfig {

    /**
     * 配置 sql打印拦截器
     * application.yml中 febs.showsql: true 时生效
     *
     * @return SqlStatementInterceptor
     */
    @Bean
    @ConditionalOnProperty(name = "rs.showSql", havingValue = "true")
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }
}
