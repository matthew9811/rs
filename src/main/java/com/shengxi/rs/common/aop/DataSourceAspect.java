package com.shengxi.rs.common.aop;


import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.annotation.DataSource;
import com.shengxi.rs.common.handler.DynamicDataSourceContextHolder;
import com.shengxi.system.common.constant.DataSourceType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源处理
 *
 * @author matthew
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.shengxi.rs.common.annotation.DataSource)")
    public void dsPointCut() {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature signature = (MethodSignature) point.getSignature();

        Method method = signature.getMethod();

        DataSource dataSource = method.getAnnotation(DataSource.class);

        if (ObjectUtil.isNotNull(dataSource)) {
            logger.info("DataSource switch to: {}", dataSource.value().name());
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value().name());
        }

        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }
}
