package com.shengxi.rs.common.util.web;

import com.alibaba.fastjson.JSONObject;
import com.shengxi.rs.common.annotation.Log;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author matthew
 * @date 2019.05.14
 * 响应util类
 */
public class ResponseUtil {

    private static final String TOKEN_KEY = "token";

    /**
     * 响应json数据页面
     *
     * @param response response
     * @param status   状态码
     * @param data     数据
     */
    public static void responseJson(HttpServletResponse response, int status, Object data) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status);
        response.getWriter().write(JSONObject.toJSONString(data));
        response.setHeader("token", JSONObject.toJSONString(data));
    }

    public static void responseJson(HttpServletResponse response, int status, Authentication authentication, Object data) throws IOException {
        response.setHeader("Access-Control-Expose-Headers", "Cache-Control,Content-Type,Expires,Pragma,Content-Language,Last-Modified,token");
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status);
        response.getWriter().write(JSONObject.toJSONString(data));
        response.setHeader("token", JSONObject.toJSONString(data));
        response.setHeader("authentication", authentication.toString());
    }


    public static void setCookie(HttpServletResponse httpServletResponse, Object data) {
        Cookie cookie = new Cookie(TOKEN_KEY, JSONObject.toJSONString(data));
        cookie.setMaxAge(2 * 60 * 60);
        cookie.setPath("/");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.addCookie(cookie);
    }
}
