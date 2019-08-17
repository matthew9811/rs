package com.shengxi.rs.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Matthew
 * @Date: 2019/4/6 23:35
 * @Description: 日志打印注解
 */
@Inherited
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}


//~ Formatted by Jindent --- http://www.jindent.com
