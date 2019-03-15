package com.shengxi.rs.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String test(){
        return prifix + "/index";
    }
}
