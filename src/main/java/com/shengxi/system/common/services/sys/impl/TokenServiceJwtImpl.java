package com.shengxi.system.common.services.sys.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.rs.common.domain.Token;
import com.shengxi.system.common.services.sys.TokenService;
import com.shengxi.rs.common.util.RedisUtil;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * token服务类
 *
 * @author matthew
 */
@Primary
@Service
public class TokenServiceJwtImpl implements TokenService {

    /**
     * 过期秒数
     */
    @Value("${token.expire.seconds}")
    private Integer expireSeconds;

    @Resource
    private RedisTemplate<String, SecurityUser> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    private static Key KEY = null;

    private static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    /**
     * 秘钥
     */
    @Value("${token.jwtSecret}")
    private String jwtSecret;

    @Override
    public Token saveToken(SecurityUser securityUser) {
        securityUser.setToken(UUID.randomUUID().toString());
        String jwtToken = createJWTToken(securityUser);
        cacheUser(securityUser);
        return new Token(jwtToken, securityUser.getLoginTime());
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
    public SecurityUser getSecurityUser(String jwtToken) {
        String uuid = getUUidFromJWT(jwtToken);
        if (ObjectUtil.isNotNull(uuid)) {
            return redisUtil.get(getTokenKey(uuid), SecurityUser.class);
        }
        return null;
    }


    @Override
    public boolean deleteToken(String jwtToken) {
//        String uuid = getUUidFromJWT(jwtToken);
//        if (ObjectUtil.isNotNull(uuid)) {
//            String key = getTokenKey(uuid);
//            SecurityUser user = redisTemplate.opsForValue().get(key);
//            if (ObjectUtil.isNotNull(user)) {
//                redisTemplate.delete(key);
//                return true;
//            }
//        }
        return false;
    }

    private void cacheUser(SecurityUser securityUser) {
        securityUser.setLoginTime(System.currentTimeMillis());
        securityUser.setExpireTime(securityUser.getLoginTime() + expireSeconds * 1000);
        /*缓存*/
        redisUtil.set(getTokenKey(securityUser.getToken()), securityUser);
    }

    private String getUUidFromJWT(String jwtToken) {
        Map<String, Object> jwtClaims = null;
        jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken).getBody();

        return MapUtil.getStr(jwtClaims, LOGIN_USER_KEY);
    }

    private String getTokenKey(String token) {
        return "tokens:" + token;
    }

    private String createJWTToken(SecurityUser securityUser) {

        Map<String, Object> claims = new HashMap<>();
        /*放入一个随机字符串，通过该串可找到登陆用户*/
        claims.put(LOGIN_USER_KEY, securityUser.getToken());
        String jwtToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance())
                .compact();

        return jwtToken;
    }

    private Key getKeyInstance() {
        if (ObjectUtil.isNull(KEY)) {
            synchronized (TokenServiceJwtImpl.class) {
                if (ObjectUtil.isNull(KEY)) {
                    byte[] base64Binary = DatatypeConverter.parseBase64Binary(jwtSecret);
                    KEY = new SecretKeySpec(base64Binary, SignatureAlgorithm.HS256.getJcaName());
                }
            }
        }
        return KEY;
    }

}