package com.shengxi.system.common.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: Matthew
 * @Date: 2019/4/19 14:46
 * @Description: redis常用操作
 */
@Service("redisServices")
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 使用字符串作为模本引擎
     */
    public void init() {
        redisTemplate = new StringRedisTemplate();
    }
}
