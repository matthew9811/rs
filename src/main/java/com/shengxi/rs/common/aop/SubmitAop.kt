package com.shengxi.rs.common.aop

import com.shengxi.rs.common.annotation.Submit
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

/**
 * @author matthew
 * @see SubmitAop
 * @since 1.0.0
 */

@Aspect
@Component
class SubmitAop {
    @Pointcut("@annotation(com.shengxi.rs.common.annotation.Submit)")
    fun pointcut() {
    }

    @Around(value = "pointcut() && @annotation(submit)")
    fun around(point: ProceedingJoinPoint, submit: Submit) {
        println(">>>point: $point")
        println(">>>url:  ${submit.url}")
    }
}