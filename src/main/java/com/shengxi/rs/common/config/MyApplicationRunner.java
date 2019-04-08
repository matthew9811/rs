package com.shengxi.rs.common.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 修改对应的启动提示
 *
 * @author : Matthew
 * @Date: 2019/3/16 00:59
 * @Description:
 */
@Component
@Order(1)
public class MyApplicationRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------->" + "项目启动，now=" + new Date());
    }
}
