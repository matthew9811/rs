package com.shengxi.rs.common.interceptor;

import com.shengxi.rs.common.annotation.permission.LoginRequired;
import com.shengxi.rs.common.filter.TokenFilter;
import com.shengxi.system.common.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author matthew
 * @version 1.0.0
 * @Description: 登录状态验证
 * @Date: 2019年6月27日 23:01:19
 * @see org.springframework.web.servlet.HandlerInterceptor
 * @since 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 1.判断是否存在注解
     * 不存在才需要检查
     * 2.不存在LoginRequired注解，则直接通过
     * 2.required=false,则无需检查是否登录
     * 3.登录状态检查,使用response返回指定信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            LOGGER.info(" not HandlerMethod type, no check");
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        boolean hasLoginAnnotation = method.getMethod().isAnnotationPresent(LoginRequired.class);
        if (!hasLoginAnnotation) {
            LOGGER.info("no LoginRequired annotation，passing");
            return true;
        }
        LoginRequired loginRequired = method.getMethod().getAnnotation(LoginRequired.class);

        if (!loginRequired.required()) {
            LOGGER.info("required=false, no check");
            return true;
        }

        LOGGER.info("required=true,need check");
        String token = TokenFilter.getToken(request);
        if (StringUtils.isNull(token)) {
            response.getWriter().append("you need login!");
            response.sendRedirect("/main");
            return false;
        }
        return true;
    }
}

