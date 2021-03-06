package com.shengxi.rs.controller.sys;

import cn.hutool.core.util.BooleanUtil;
import com.shengxi.rs.common.handler.BaseController;

import com.shengxi.system.model.service.sys.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * main跳转
 *
 * @author 主页控制器
 */
@Controller
@RequestMapping("/")
public class MainController extends BaseController {


    private SysMenuService menuService;

    @Autowired
    public void setMenuService(SysMenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 项目启动主页
     *
     * @return 登录页
     */
    @GetMapping("/")
    public String init() {
        return "login";
    }

    /**
     * 跳转主页
     */
    @GetMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 进入index页面
     * 加载对应的菜单
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.put("menu", menuService.selectByList());
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (BooleanUtil.isFalse(auth instanceof AnonymousAuthenticationToken)){
            return "index";
        }
        return "login";
    }

    @RequestMapping("/404")
    public String error404(){
        return "404";
    }
}
