package com.shengxi.rs.controller.test;

import cn.hutool.core.lang.UUID;
import com.shengxi.rs.common.constant.SysConstant;
import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.model.service.sys.impl.SysUserServiceImpl;
import com.shengxi.system.model.service.test.TestServices;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Matthew
 * @Date: 2019/3/14 20:48
 * @Description:
 */
public class TestTest {

    @Autowired
    private TestServices testServices;

    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @Test
    public void test1() {
    }

    @Test
    public void testId() {
            System.out.println(IdUtil.uuid());
    }

    @Test
    public void testMybatis(){
        System.out.println(testServices.selectList());
    }

    @Test
    public void testIG(){
        List<String> test1 = new ArrayList<>();
        List<String> test2 = new ArrayList<>();
        for (int i = 0; i < 100000; i ++){
            test1.add(cn.hutool.core.util.IdUtil.simpleUUID());
        }
        for (int i = 0; i < 100000; i ++){
            test2.add(cn.hutool.core.util.IdUtil.simpleUUID());
        }
        for (int i = 0; i < 100000; i++){
            if (test1.contains(test2.get(i))){
                System.out.println(true);
            }
        }
    }

    @Test
    public void testUU(){
        System.out.println(UUID.randomUUID(true));
        System.out.println(cn.hutool.core.util.IdUtil.createSnowflake(SysConstant.WORK_ID, SysConstant.DATA_CENTER_ID).nextId());
    }

    @Test
    public void insertUser(){
        SysUser user = new SysUser();
        user.setUserNo("admin");
        user.setUserName("晟曦");
        user.setPassword("admin");
        user.setCreateTime(new Date());
        sysUserServiceImpl.saveUser(user);
    }

}