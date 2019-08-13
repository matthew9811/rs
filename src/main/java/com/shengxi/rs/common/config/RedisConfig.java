package com.shengxi.rs.common.config;

import com.shengxi.rs.common.domain.RedisYml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: Matthew
 * @Date: 2019/4/6 16:47
 * @Description: Redis 缓存配置类
 */

@EnableCaching
@EnableRedisHttpSession
@Configuration
public class RedisConfig {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    private RedisYml redisYml;

    @Autowired
    public void setRedisYml(RedisYml redisYml) {
        this.redisYml = redisYml;
    }


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
        logger.debug(">>>>>>redisConfig>>>>>:" + redisYml.getHost() + ":" + redisYml.getPort());
        return new JedisPool(new JedisPoolConfig(), redisYml.getHost(), redisYml.getPort(), redisYml.getTimeout(), redisYml.getPassword());
    }

}

