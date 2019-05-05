package com.shengxi.rs.controller.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 教务审批跳转
 *
 * @author 郑杰
 * @date  2019/3/25 10:25
 * 教务审批跳转
 */
@Controller
@RequestMapping("/administration/administration")
public class AdministrationController {
    private  String prefix = "administration";

    @GetMapping("/approval")
    public String approval() {
        return prefix + "/approval";
    }

    @GetMapping("/replace")
    public String replace() {
        return prefix + "/replace";
    }
    @GetMapping("/upload")
    public String upload() {
        return prefix + "/upload";


    }
}
