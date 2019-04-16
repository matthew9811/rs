package com.shengxi.rs.controller.test;

import com.shengxi.system.model.mapper.test.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Matthew
 * @Date: 2019/4/10 10:47
 * @Description:
 */
@RunWith(SpringRunner.class)
@org.mybatis.spring.boot.test.autoconfigure.MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MybatisTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    @Rollback(value = false)
    public void testSelectList(){
        System.out.println(testMapper.selectTestEntityList());
    }

}
