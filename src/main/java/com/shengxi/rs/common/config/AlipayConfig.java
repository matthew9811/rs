package com.shengxi.rs.common.config;

import jdk.management.resource.ResourceRequestDeniedException;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class AlipayConfig implements ApplicationListener {

    /**
     * 储存参数
     */
    private static Map<String, String> alipayMap = new HashMap<>();

    /**
     * 获取配置参数
     *
     * @param key key String
     * @return value
     */
    public static String getKey(String key) {
        return alipayMap.get(key);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationReadyEvent) {
            this.init(alipayMap);
        }
    }

    /**初始化加载aliPropertiesMap*/
    public void init(Map<String, String> alipayMap) {
        // 获得PathMatchingResourcePatternResolver对象
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource resource = resolver.getResource("classpath:conf/alipay.yml");
            PropertiesFactoryBean config = new PropertiesFactoryBean();
            config.setLocation(resource);
            config.afterPropertiesSet();
            Properties properties = config.getObject();
            this.forEach(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void forEach(Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            alipayMap.put(key, String.valueOf(properties.get(key)));
        }
    }
}
