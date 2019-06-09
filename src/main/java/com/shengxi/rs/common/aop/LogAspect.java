package com.shengxi.rs.common.aop;

import com.shengxi.rs.common.annotation.Log;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author matthew
 * @version 1.0.0
 * @Description: 自定义日志注解类
 * @date 2019.06.10
 * @see LogAspect
 * @since 1.0.0
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 定义切入点
     */
    @Pointcut(value = "@annotation(com.shengxi.rs.common.annotation.Log)")
    public void pointcut() {

    }

    /**
     * 在方法执行前后
     *
     * @param point
     * @param log
     * @return
     */
    @Around(value = "pointcut() && @annotation(log)")
    public Object around(ProceedingJoinPoint point, Log log) throws Throwable {

        String value = log.value();

        /* 拦截的类名 */
        Class clazz = point.getTarget().getClass();
        /* 拦截的方法 */
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        String name = method.getName();
        System.out.println("执行了 类:" + clazz + " 方法:" + name + " 实现操作:" + value);
        /* 执行程序 */
        return point.proceed();
    }

    /**
     * 方法执行后
     *
     * @param joinPoint
     * @param myLog
     * @param result
     * @return
     * @deprecated
     */
//    @Deprecated
//    @AfterReturning(value = "pointcut() && @annotation(myLog)", returning = "result")
//    public Object afterReturning(JoinPoint joinPoint, Log myLog, Object result) {
//
//        System.out.println("执行结果：" + result);
//
//        return result;
//    }

    /**
     * 方法执行后 并抛出异常
     *
     * @param myLog
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(myLog)", throwing = "ex")
    public void afterThrowing(Log myLog, Exception ex) {
        System.out.println("请求：" + myLog.value() + " 出现异常");
    }

}
