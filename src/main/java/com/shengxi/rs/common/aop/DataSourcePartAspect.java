package com.shengxi.rs.common.aop;

import com.shengxi.rs.common.constant.DataSourceType;
import com.shengxi.rs.common.handler.DynamicDataSourceContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 默认对应的数据库源
 * @author matthew
 * @date 2019年8月8日 11:09:45
 */
@Aspect
@Order(-1)
@Component
public class DataSourcePartAspect {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * mapper 查询操作默认使用从库
     */
    @Before("execution(* com..service..*.select*(..)) || " +
            "execution(* com..service..*.get*(..))|| " +
            "execution(* com..service..*.query*(..))")
    public void setReadDataSourceType() {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        log.info("dataSource 切换到：{}", DataSourceType.SLAVE.name());
    }

    /**
     * mapper 修改删除操作默认使用主库库
     */
    @Before("execution(* com..service..*.insert*(..)) || " +
            "execution(* com..service..*.change*(..)) || " +
            "execution(* com..service..*.update*(..)) || " +
            "execution(* com..service..*.delete*(..))")
    public void setWriteDataSourceType() {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.MASTER.name());
        log.info("dataSource 切换到：{}", DataSourceType.MASTER.name());
    }
}
