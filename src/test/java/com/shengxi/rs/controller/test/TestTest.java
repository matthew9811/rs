package com.shengxi.rs.controller.test;

import cn.hutool.core.lang.UUID;
import com.shengxi.rs.common.contant.SysContant;
import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.system.model.service.test.TestServices;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: Matthew
 * @Date: 2019/3/14 20:48
 * @Description:
 */
public class TestTest {

    @Autowired
    private TestServices testServices;

    @Test
    public void test1() {
    }

    @Test
    public void testId() {
//        for (int i = 0; i < 1000; i++) {
            System.out.println(IdUtil.uuid());
//        }
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
        System.out.println(cn.hutool.core.util.IdUtil.createSnowflake(SysContant.WORK_ID,SysContant.DATA_CENTER_ID).nextId());
    }
}