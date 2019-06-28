package com.shengxi.rs.common.annotation.permission;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解在class字节码文件中存在，在运行时可以通过反射获取到
 * 可以继承的注解
 * 可以被doc识别
 * 可以使用在方法method
 * 可以使用在接口、类、枚举、注解
 *
 * @author: matthew
 * @Date: 2019年6月27日 22:58:48
 * @Description: 不需要登录的请求状态注解, 使用该注解的controller或者method不需要进行登录验证，准确的说是不需要可持续的登录状态。
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface LoginRequired {
    boolean required() default false;
}
