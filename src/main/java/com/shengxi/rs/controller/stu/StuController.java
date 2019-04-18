package com.shengxi.rs.controller.stu;

import com.shengxi.system.entites.stuEntity.StuRehabilitation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/news")
    public String pnews() {
        return "redirect:/stu/stu/news";
    }
    @PostMapping("/course")
    public String pcourse() {
        return "redirect:/stu/stu/course";
    }
    @PostMapping("/choose")
    public String pchoose() {
        return "redirect:/stu/stu/choose";
    }

    @GetMapping("/course")
    public String course() {
        return prifix + "/course";
    }

    @GetMapping("/news")
    public String news() {
        return prifix + "/news";
    }
    @GetMapping("/search")
    public String search() {
        return prifix + "/search";
    }
    @GetMapping("/choose")
    public String choose() {
        return prifix + "/choose";
    }

    @RequestMapping("")
    public String test() {
        return "/test/index";
    }
}
