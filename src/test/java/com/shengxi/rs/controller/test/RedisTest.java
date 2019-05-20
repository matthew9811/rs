package com.shengxi.rs.controller.test;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.RsApplication;
import com.shengxi.system.common.constant.Index;
import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.entites.test.TestEntity;
import com.shengxi.system.model.service.sys.SysMenuServices;
import com.shengxi.system.model.service.sys.SysUserServices;
import com.shengxi.system.model.service.test.TestServices;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    SysMenuServices menuServices;

    @Autowired
    private SysUserServices userServices;

    @Autowired
    private TestServices testServices;

    @Test
    @Rollback
    public void stringTest() {
        ValueOperations<String, String> opsValStr = stringObjectStringRedisTemplate.opsForValue();
        opsValStr.set("焰皓", "焰豪");
        System.out.println("=================================");
        System.out.println(opsValStr.get("焰皓"));
    }

    @Test
    @Rollback
    public void setTest(){
        Boolean delete = stringObjectStringRedisTemplate.delete("焰皓");
        System.out.println(delete);
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

    @Test
    @Rollback
    public void testTree(){
        System.out.println(menuServices.selectByInit());
    }

    @Test
    public void insertUser(){
        SysUser user = new SysUser();
        user.setUserNo("admin");
        user.setUserName("晟曦");
        user.setPassword("admin");
        user.setCreateTime(new Date());
        userServices.saveUser(user);
    }
}
