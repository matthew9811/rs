package com.shengxi.rs.controller.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;


/**
 * @author 郑杰
 * @date 2019/3/27 16:37
 * 登录表接受数据跳转
 */
@Controller
@RequestMapping("/login/login")
public class LoginController {

    private Pattern pattern = Pattern.compile("[0-9]*");
    private String prefix = "login";

    @GetMapping("/")
    public String login() {
        return prefix + "/login";
    }

    @RequestMapping(value = "/judge", method = RequestMethod.POST)
    public String judge(String id, String password, HttpSession session) {
        session.setAttribute("id", id);
        if (id.startsWith("neusoft", 0)) {
            return "redirect:/administration/administration/approval";
        }
        if (id.startsWith("CST", 0)) {
            return "redirect:/college/college/classbegins";
        }
        if (pattern.matcher(id).matches()) {
            return "redirect:/stu/stu/stuAccept";
        }
        return "redirect:/test/index";
    }
}
