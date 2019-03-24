package com.shengxi.rs.controller.stu;

import com.shengxi.system.entites.stuEntity.StuRehabilitation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学生申请表接受跳转
 *
 * @author 郑杰
 * @date 2019/3/24 16:17
 * 学生申请表接受跳转
 */
@Controller
@RequestMapping("/stu/stu")
public class StuController {

    private String prifix = "stu";

    @PostMapping("/stuAccept")
    @ResponseBody
    public String studentAccept(StuRehabilitation stuRehabilitationEntity) {
        System.out.println(stuRehabilitationEntity.toString());
        return stuRehabilitationEntity.toString();
    }

    @GetMapping("/stuAccept")
    public String studentAccept() {
        return prifix + "/course";
    }

    @RequestMapping("")
    public String test() {
        return "/test/index";
    }
}
