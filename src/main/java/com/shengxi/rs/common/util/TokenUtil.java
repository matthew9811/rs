package com.shengxi.rs.common.util;

import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.system.common.services.sys.TokenService;
import com.shengxi.system.common.services.sys.impl.TokenServiceJwtImpl;

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
