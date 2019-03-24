package com.shengxi.rs.controller.studentapplicationformforfehabilitation;

import com.shengxi.system.entites.StudentApplicationFormForRehabilitationEntites;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学生申请表接受跳转
 * @author 郑杰
 * @date 2019/3/24 16:17
 * @deprecated  学生申请表接受跳转
 */
@Controller
@RequestMapping("/studentApplicationFormForRehabilitation")
public class StudentApplicationFormForRehabilitationContoller {
    private String prifix = "studentApplicationFormForRehabilitation";
    @PostMapping("/studentAcceptance")
    @ResponseBody
    public  String studentAcceptance(StudentApplicationFormForRehabilitationEntites studentApplicationFormForRehabilitationEntites){
        System.out.println(studentApplicationFormForRehabilitationEntites.toString());
        return studentApplicationFormForRehabilitationEntites.toString();
    }

    @GetMapping("/studentAcceptance")
    public String studentAcceptance(){
        return prifix + "/courseapplication";
    }
    @RequestMapping("")
    public String test() {
        return "/test/index";
    }
}
