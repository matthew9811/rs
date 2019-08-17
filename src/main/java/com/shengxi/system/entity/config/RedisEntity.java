package com.shengxi.system.entity.config;

import java.util.HashMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Des
 * @author  matthew
 */

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisEntity {

    private String host;

    private int port;

    private int timeout;

    private String password;

    private HashMap<String, String> pool = new HashMap<>();

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, String> getPool() {
        return pool;
    }

    public void setPool(HashMap<String, String> pool) {
        this.pool = pool;
    }
}

