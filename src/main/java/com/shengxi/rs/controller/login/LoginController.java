package com.shengxi.rs.controller.login;


import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.system.common.services.sys.UserDetailsServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(SecurityUser user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserNo());
        if (ObjectUtil.isNotNull(userDetails)) {
            return "index";
        }
        return "login";
    }

}
