package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.AjaxResult;
import com.shengxi.system.common.constant.BaseControllerConstant;
import com.shengxi.system.common.util.SecurityUserUtil;
import com.shengxi.system.entites.sys.SysMenuEntity;
import com.shengxi.system.model.service.sys.SysMenuServices;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author matthew
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    private String prefix = "/admin";

    @Autowired
    private SysMenuServices menuServices;

    @GetMapping()
    public String index() {
        return prefix + "/menu";
    }

    @GetMapping("/getMenu")
    @ResponseBody
    public Map<String, Object> getMenu() {
        return menuServices.selectByInit();
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }


    @PostMapping("/add")
    public AjaxResult insertMenu(SysMenuEntity sysMenuEntity) {
        /**
         * 控制del_flag
         */
        sysMenuEntity.setCreateBy(SecurityUserUtil.getUserId());
        sysMenuEntity.setDelFlag(BaseControllerConstant.DEL_FLAG_NOT);
        return toAjax(menuServices.insertEntity(sysMenuEntity));
    }


}
