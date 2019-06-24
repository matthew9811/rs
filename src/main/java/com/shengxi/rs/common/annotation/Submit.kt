package com.shengxi.rs.common.annotation

import org.springframework.stereotype.Component


@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class Submit(val url: String = "")