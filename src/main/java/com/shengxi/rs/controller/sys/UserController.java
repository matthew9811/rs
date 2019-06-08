package com.shengxi.rs.controller.sys;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.web.TokenUtil;
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
@RequestMapping("/user")
public class UserController extends BaseController {

    private String prefix = "/admin/user";

    @PostMapping("/current")
    @ResponseBody
    public SecurityUser currentUser(String token) {
        SecurityUser user = TokenUtil.getUser(token);
        if (ObjectUtil.isNull(user)){
            user = new SecurityUser();
        }
        return user;
    }

    @GetMapping("/")
    public String index() {
        return prefix + "/user";
    }
}
