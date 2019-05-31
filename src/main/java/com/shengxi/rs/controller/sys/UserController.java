package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.TokenUtil;
import com.shengxi.rs.common.util.UserUtil;
import com.shengxi.system.entites.sys.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/current/{token}")
    @ResponseBody
    public SysUser currentUser(@PathVariable("token") String token) {
        return TokenUtil.getUser(token);
    }

    @GetMapping("")
    public String index() {
        return prefix + "/user";
    }
}
