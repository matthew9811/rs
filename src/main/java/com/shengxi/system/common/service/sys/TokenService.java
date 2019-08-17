package com.shengxi.system.common.service.sys;

import com.shengxi.system.entity.config.SecurityUser;
import com.shengxi.system.entity.config.Token;

/**
 * token管理器
 *
 * @author matthew
 * @date 2019.05.15
 */
public interface TokenService {

    /**
     * 保存token
     * @param securityUser user
     * @return string
     */
    Token saveToken(SecurityUser securityUser);

    /**
     * 刷新token
     * @param securityUser
     */
    void refresh(SecurityUser securityUser);

    /**
     * 获取缓存数据
     * @param token token
     * @return user
     */
    SecurityUser getSecurityUser(String token);

    /**
     * 删除token
     * @param token string
     * @return boolean
     */
    boolean deleteToken(String token);
}
