package com.shengxi.rs.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: Matthew
 * @Date: 2019/4/6 16:47
 * @Description: Redis 缓存配置类
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Autowired
    JedisPool jedisPool;

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.database}")
    Integer database;
    @Value("${spring.redis.password}")
    String password;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Bean("redisTemplate")
    public RedisTemplate redisTemplate(@Lazy RedisConnectionFactory connectionFactory) {
        RedisTemplate redis = new RedisTemplate();
        GenericToStringSerializer<String> keySerializer = new GenericToStringSerializer<>(String.class);
        redis.setKeySerializer(keySerializer);
        redis.setHashKeySerializer(keySerializer);
        GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
        redis.setValueSerializer(valueSerializer);
        redis.setHashValueSerializer(valueSerializer);
        redis.setConnectionFactory(connectionFactory);

        return redis;
    }

    /**
     * 初始化连接池
     * public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password) {
     * this(poolConfig, host, port, timeout, password, 0, (String)null);
     * }
     *
     * @return JedisPool
     */
    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

//        JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout, password);
        JedisPool jedisPool = new JedisPool(poolConfig, "47.106.188.177");
        return jedisPool;
    }

}

