package com.shengxi.rs.controller.sys.menu;

import com.shengxi.rs.common.domain.SecurityUser;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.AjaxResult;
import com.shengxi.system.common.contant.BaseControllerContant;
import com.shengxi.system.common.util.SecurityUserUtil;
import com.shengxi.system.entites.sys.SysMenuEntity;
import com.shengxi.system.model.service.sys.SysMenuServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author matthew
 */
@Controller
@RequestMapping("/menu")
public class menuController extends BaseController {

    private String perfix = "/admin";

    @Autowired
    private SysMenuServices menuServices;

    public List<?> getMenu(){
        return null;
    }

    @GetMapping("/add")
    public String add(){
        return perfix + "/menuCreate";
    }

    @PostMapping("/add")
    public AjaxResult insertMenu(SysMenuEntity sysMenuEntity){
        /**
         * 控制del_flag
         */
        sysMenuEntity.setCreateBy(SecurityUserUtil.getUserId());
        sysMenuEntity.setDelFlag(BaseControllerContant.DEL_FLAG_NOT);
        return toAjax(menuServices.insertEntity(sysMenuEntity));
    }
}
