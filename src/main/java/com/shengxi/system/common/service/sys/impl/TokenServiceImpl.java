package com.shengxi.system.common.service.sys.impl;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.entity.config.SecurityUser;
import com.shengxi.system.entity.config.Token;
import com.shengxi.system.common.service.sys.TokenService;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * token管理器
 *
 * @author matthew
 * @date 2019.05.15
 */
@Deprecated
public class TokenServiceImpl implements TokenService {

    /**
     * 过期秒数
     */
    @Value("${token.expire.seconds}")
    private Integer expireSeconds;

    @Autowired
    private RedisTemplate<String, SecurityUser> redisTemplate;

    @Override
    public Token saveToken(SecurityUser securityUser) {
        String token = UUID.randomUUID().toString();
        securityUser.setToken(token);
        cacheUser(securityUser);
        return new Token(token, securityUser.getLoginTime());
    }

    /**
     * 刷新缓存
     *
     * @param securityUser securityUser
     */
    @Override
    public void refresh(SecurityUser securityUser) {
        cacheUser(securityUser);
    }

    @Override
    public SecurityUser getSecurityUser(String token) {
        return redisTemplate.boundValueOps(getTokenKey(token)).get();
    }

    @Override
    public boolean deleteToken(String token) {
        String key = getTokenKey(token);
        SecurityUser user = redisTemplate.boundValueOps(getTokenKey(token)).get();
        if (ObjectUtil.isNotNull(user)) {
            redisTemplate.delete(key);
            return true;
        }
        return false;
    }

    private void cacheUser(SecurityUser securityUser) {
        securityUser.setLoginTime(System.currentTimeMillis());
        securityUser.setExpireTime(securityUser.getLoginTime() + expireSeconds * 1000);
        //缓存
        redisTemplate.boundValueOps(getTokenKey(securityUser.getToken())).set(securityUser, expireSeconds, TimeUnit.SECONDS);
    }

    private String getTokenKey(String token) {
        return "tokens:" + token;
    }
}
