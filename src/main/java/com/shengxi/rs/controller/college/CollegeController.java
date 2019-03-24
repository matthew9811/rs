package com.shengxi.rs.controller.college;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学院审批页跳转
 *
 * @author 郑杰
 * @date 2019/3/25 01:50
 * 学院审批页跳转
 */
@Controller
@RequestMapping("/college/college")
public class CollegeController {
    private String prifix = "college";

    @GetMapping("/classbegins")
    public String classbegins() {
        return prifix + "/classbegins";
    }

    @GetMapping("/subordinate")
    public String subordinate() {
        return prifix + "/subordinate";
    }
}
