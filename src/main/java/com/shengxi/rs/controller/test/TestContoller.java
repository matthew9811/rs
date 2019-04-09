package com.shengxi.rs.controller.test;

import com.shengxi.system.entites.test.TestEntity;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Matthew
 * @Date: 2019/3/14 17:00
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class TestContoller {
    private String prifix = "test";

    @RequestMapping("")
    public String test() {
        return prifix + "/index";
    }

    @GetMapping("/input")
    public String input() {
        return prifix + "/inputTest";
    }

    @PostMapping("/input")
    @ResponseBody
    public String input(TestEntity entity) {
        System.out.println(entity.toString());
        return entity.toString();
    }

}
