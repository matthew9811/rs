package com.shengxi.rs.controller.test;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.RsApplication;
import com.shengxi.system.common.contant.Index;
import com.shengxi.system.entites.test.TestEntity;
import com.shengxi.system.model.service.test.TestServices;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Matthew
 * @Date: 2019/4/7 21:24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RsApplication.class)
@WebAppConfiguration
public class RedisTest {

    @Autowired
    StringRedisTemplate stringObjectStringRedisTemplate;

    @Autowired
    private TestServices testServices;

    @Test
    public void stringTest() {
        ValueOperations<String, String> opsValStr = stringObjectStringRedisTemplate.opsForValue();
        opsValStr.set("焰皓", "焰豪");
        System.out.println("=================================");
        System.out.println(opsValStr.get("焰皓"));
    }

    @Test
    @Rollback
    public void testMybatis() {
        System.out.println(testServices.selectList());
    }

    @Test
    @Rollback
    public void testUpdate() {
        List<TestEntity> entityList = testServices.selectList();
        if (ObjectUtil.isNotNull(entityList)) {
            TestEntity testEntity = entityList.get(Index.INDEX_FIRST);
            testEntity.setName("焰皓");
            testEntity.setAge(2);
            Integer result = testServices.updateTest(testEntity);
            System.out.println("sql中受影响的条数为:  " + result);
        }
    }

}
