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
import org.springframework.ui.ModelMap;
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
    public Map<String, Object> getMenu(SysMenuEntity menuEntity) {
        return menuServices.selectByInit(menuEntity);
    }

    /**
     * 新增菜单
     *
     * @param map model
     * @return url
     */
    @GetMapping("/add")
    public String add(ModelMap map) {
        map.put("parentList", menuServices.selectOfParentAdd());
        return prefix + "/add";
    }


    /**
     * 保存添加
     *
     * @param sysMenuEntity 菜单实体
     * @return ajaxData
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult insertMenu(SysMenuEntity sysMenuEntity) {
        /**
         * 控制del_flag
         */
        sysMenuEntity.setCreateBy(SecurityUserUtil.getUserId());
        sysMenuEntity.setDelFlag(BaseControllerConstant.DEL_FLAG_NOT);
        //暂时使用
        sysMenuEntity.setCreateBy("admin");
        return toAjax(menuServices.insertEntity(sysMenuEntity));
    }


}
