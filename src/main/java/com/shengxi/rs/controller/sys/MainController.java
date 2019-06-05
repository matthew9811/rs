package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.rs.common.handler.BaseController;
import javax.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * main跳转
 * @author 主页控制器
 */
@Controller
@RequestMapping("/")
public class MainController extends BaseController {


    /**
     * 项目启动主页
     * @return 登录页
     */
    @GetMapping("/")
    public String init() {
        return "login";
    }

    /**
     * 跳转主页
     * */
    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/login")
    public String login(){
        return "index";
    }
}
