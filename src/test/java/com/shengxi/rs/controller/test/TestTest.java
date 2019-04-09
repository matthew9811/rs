package com.shengxi.rs.controller.test;

import com.shengxi.rs.common.util.IdUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: Matthew
 * @Date: 2019/3/14 20:48
 * @Description:
 */
public class TestTest {

    @Test
    public void test1() {
    }

    @Test
    public void testId() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(IdUtil.uuid());
        }
    }
}