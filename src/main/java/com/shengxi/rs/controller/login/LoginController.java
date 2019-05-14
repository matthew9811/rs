package com.shengxi.rs.controller.login;


import com.shengxi.rs.common.domain.SecurityUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 郑杰
 * @date 2019/3/27 16:37
 * 登录表接受数据跳转
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private Pattern pattern = Pattern.compile("[0-9]*");
    private String prefix = "login";

    @GetMapping()
    public String login() {
        return prefix + "/login";
    }

    @PostMapping()
    @ResponseBody
    public String login(SecurityUser user){
        return null;
    }
}
