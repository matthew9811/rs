package com.shengxi.rs.common.util;

import com.shengxi.rs.common.domain.SecurityUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * 用户工具类
 *
 * @author matthew
 * @date 2019/05/19
 */
public class UserUtil {
    /**
     * 利用spring security获取当前登录用户
     *
     * @return securityUser
     */
    public static SecurityUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return (SecurityUser) authentication.getPrincipal();
            }
        }
        return null;
    }

    /**
     * 返回用户信息 no
     *
     * @return userNo
     */
    public static String getUserNo() {
        return getLoginUser().getUserNo();
    }
}
