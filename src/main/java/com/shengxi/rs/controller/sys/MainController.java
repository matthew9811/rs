package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.handler.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * main跳转
 * @author 主页控制器
 */
@Controller
@RequestMapping("/")
public class MainController extends BaseController {


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
}
