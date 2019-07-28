package com.shengxi.rs.common.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @author matthew
 * 自定义redis序列化
 */
@Component
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;

    private int timeout;

    /**
     * 获取值
     *
     * @param key   key
     * @param clazz Class
     * @param <T>   T
     * @return Object
     */
    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String str = jedis.get(key);
            T t = stringToBean(str, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * set值
     */
    public <T> boolean set(String key, T value) {
       return this.setex(key, value, this.timeout);
    }

    /**
     * set值并设置对应的过期时间
     * @param key key
     * @param value value
     * @param timeout time
     * @param <T> obj
     * @return flag
     */
    public <T> boolean setex(String key, T value, Integer timeout){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if (str == null || str.length() <= 0) {
                return false;
            }
            if (timeout <= 0) {
                jedis.set(key, str);
            } else {
                jedis.setex(key, timeout, str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 查看key是否存在
     *
     * @param key key
     * @return boolean
     */
    public boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 删除对应的数据
     *
     * @param key
     * @return trur?false
     */
    public boolean delete(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long result = jedis.del(key);
            return result > 0;
        } finally {
            returnToPool(jedis);
        }
    }

    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * 序列化String转对象
     *
     * @param str   ClassStr
     * @param clazz Class
     * @param <T>   T
     * @return Bean
     */
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    /**
     * 释放资源
     *
     * @param jedis jedis
     */
    public void returnToPool(Jedis jedis) {
        if (ObjectUtil.isNotNull(jedis)) {
            jedis.close();
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
