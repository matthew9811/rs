package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.common.util.UserUtil;
import com.shengxi.system.entity.sys.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色管理器
 * @author chuling
 * @date 2019-05-22
 */
@RequestMapping("/admin/role")
@Controller
public class RoleController extends BaseController {

    private String prefix = "/admin/role";

    @GetMapping("/current")
    public SysUser currentUser() {
        return UserUtil.getLoginUser();
    }

    @GetMapping("/")
    public String index() {
        return prefix + "/role";
    }

}
