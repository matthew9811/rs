package com.shengxi.rs.controller.sys;

import com.shengxi.system.entity.config.SecurityUser;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.common.util.web.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理控制器
 *
 * @author matthew
 * @date 2019/05/19
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    private String prefix = "/admin/user";

    @PostMapping("/admin/current")
    @ResponseBody
    public SecurityUser currentUser(String token) {

        return TokenUtil.getUser(token);
    }

    @GetMapping()
    public String index() {
        return prefix + "/user";
    }
}
