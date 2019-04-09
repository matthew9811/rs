package com.shengxi.rs.controller.test;

import com.shengxi.RsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Matthew
 * @Date: 2019/4/7 21:24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RsApplication.class)
public class RedisTest {

    @Autowired
    StringRedisTemplate stringObjectStringRedisTemplate;

    @Test
    public void stringTest(){
        ValueOperations<String, String> opsValStr = stringObjectStringRedisTemplate.opsForValue();
        opsValStr.set("焰皓", "焰豪");
        System.out.println("=================================");
        System.out.println(opsValStr.get("焰皓"));
    }

}
