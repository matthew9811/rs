package com.shengxi.rs.common.filter;


import com.shengxi.rs.common.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author matthew
 * @Date: 2019年6月27日 17:41:24
 * @Description: 登陆验证拦截
 */
@Deprecated
@Component
public class LoginStatusFilter implements HandlerInterceptor {


    private Logger logger = LoggerFactory.getLogger(LoginStatusFilter.class);

    /**
     * 请求进去controller进行请求拦截
     * 验证是否登录
     *
     * @param request  req
     * @param response resp
     * @param handler  handler
     * @return boolean
     * @throws Exception exception
     * @Description: 请求登陆验证是否处于登录状态
     * @since 1.0
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = TokenFilter.getToken(request);
        if (StringUtils.isNull(token)) {
            response.setStatus(203);
            //未登录自动跳转界面
            logger.info("用户没有登录,重定向登陆页面");
            response.sendRedirect("/");
            return false;
        }
        //在请求处理之前进行调用（Controller方法调用之前）
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    /**
     * 请求进入controller后调用
     *
     * @param request      request
     * @param response     response
     * @param handler      handler
     * @param modelAndView modelAndView
     * @throws Exception Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求得到响应的时候调用
     *
     * @param request  request
     * @param response response
     * @param handler  handler
     * @param ex       Exception
     * @throws Exception Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
