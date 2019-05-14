package com.shengxi.rs.common.util;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * @author matthew
 * @date 2019.05.14
 * 响应util类
 */
public class ResponseUtil {
    /**
     * 响应json数据页面
     * @param response response
     * @param status 状态码
     * @param data 数据
     */
    public static void responseJson(HttpServletResponse response, int status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(status);
            response.getWriter().write(JSONObject.toJSONString(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
