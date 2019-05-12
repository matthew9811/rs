package com.shengxi.system.common.util;

import com.shengxi.rs.common.config.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 用户支撑类
 * @author matthew
 * @date 2019.05.12
 */
public class SecurityUserUtil {
    /**
     * 获取当前用户Authentication
     * @return Authentication
     */
    public static Authentication getCurrentUserAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户
     * @return getPrincipal
     */
    public static Object getCurrentPrincipal(){
        return getCurrentUserAuthentication().getPrincipal();
    }

    /**
     * 转化为当前用户
     * @return sysUser
     */
    public static SysUser getUser(){
        return (SysUser)getCurrentPrincipal();
    }

    /**
     * 获取用户id
     * @return String
     */
    public static String getUserId(){
        return getUser().getId();
    }

    /**
     * 获取用户userName
     * return String
     */
    public static String getUserName(){
        return getUser().getUserName();
    }

    /**
     * 用户编号
     * return String
     */
    public static String getUserNo(){
        return getUser().getUserNo();
    }

//    public static String getLoginName(){
//        return getCurrentUserAuthentication().getAuthorities();
//    }
}
