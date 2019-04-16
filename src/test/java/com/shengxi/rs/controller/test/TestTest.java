package com.shengxi.rs.controller.test;

import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.system.model.service.test.TestServices;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}