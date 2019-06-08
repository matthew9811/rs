package com.shengxi.rs.common.util.web;

import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.system.common.service.sys.TokenService;
import com.shengxi.system.common.service.sys.impl.TokenServiceJwtImpl;
import org.springframework.stereotype.Component;

/**
 * @author matthew
 */
public class TokenUtil {

    /**
     * token验证信息
     * @param token token
     * @return user
     */
    public static SecurityUser getUser(String token) {
        TokenService tokenService= new TokenServiceJwtImpl();
        return tokenService.getSecurityUser(token);
    }
}
