package com.shengxi.rs.common.config;

import com.shengxi.system.common.constant.PageConstant;
import org.apache.catalina.connector.Response;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: matthew
 * @ClassName RestErrorController
 * @Date: 2019-09-23 11:51
 * @Version: 1.0.0
 * 统一错误页面处理
 */
@Controller
public class RestErrorController implements ErrorController {


    /**
     * 返回错误处理的路径
     * @return page
     */
    @Override
    public String getErrorPath() {
        return PageConstant.ERROR_PATH;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == Response.SC_UNAUTHORIZED) {
            return PageConstant.ERROR_PATH.concat("/401");
        } else if (statusCode == Response.SC_NOT_FOUND) {
            return PageConstant.ERROR_PATH.concat("/404");
        } else if (statusCode == Response.SC_FORBIDDEN) {
            return PageConstant.ERROR_PATH.concat("/403");
        } else {
            return PageConstant.ERROR_PATH.concat("/500");
        }

    }

}
