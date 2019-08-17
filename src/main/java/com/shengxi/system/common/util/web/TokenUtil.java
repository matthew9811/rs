package com.shengxi.system.common.util.web;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.entity.config.SecurityUser;
import com.shengxi.system.common.service.sys.TokenService;
import com.shengxi.system.common.service.sys.impl.TokenServiceJwtImpl;

/**
 * @author matthew
 */
public class TokenUtil {

    private static TokenService tokenService= new TokenServiceJwtImpl();

    /**
     * token验证信息
     * @param token token
     * @return user
     */
    public static SecurityUser getUser(String token) {

        if (ObjectUtil.isNull(tokenService)){
            tokenService = new TokenServiceJwtImpl();
        }

        return tokenService.getSecurityUser(token);
    }
}
