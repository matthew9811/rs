package com.shengxi.rs.controller.login;


import com.shengxi.rs.common.domain.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author matthew
 * @date 2019/05/19
 * 登录控制
 */
@Controller
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/")
    public String login() {
        return   "login";
    }

    @RequestMapping("/login")
    public String login(SecurityUser user) {
        return "page/index/jump";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

}
