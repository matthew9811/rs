package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.UserUtil;
import com.shengxi.system.entites.sys.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理控制器
 * @author matthew
 * @date 2019/05/19
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/current")
    public SysUser currentUser() {
        return UserUtil.getLoginUser();
    }
}
