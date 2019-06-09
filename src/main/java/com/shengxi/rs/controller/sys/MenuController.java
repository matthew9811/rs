package com.shengxi.rs.controller.sys;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.shengxi.rs.common.annotation.Log;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.file.excel.EasyExcelUtils;
import com.shengxi.rs.common.util.web.AjaxResult;
import com.shengxi.rs.common.util.UserUtil;
import com.shengxi.system.entites.sys.SysMenu;
import com.shengxi.system.model.service.sys.impl.SysMenuServiceImpl;
import java.util.List;
import java.util.Map;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
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
@Log("menu")
public class MenuController extends BaseController {

    private String prefix = "/admin/menu";

    @Autowired
    private SysMenuServiceImpl menuServices;

    @PermitAll
    @GetMapping()
    @Log("menuIndex")
    public String index() {
        return prefix + "/menu";
    }

    @GetMapping("/getMenu")
    @ResponseBody
    public Map<String, Object> getMenu(SysMenu menuEntity) {
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
     * @param sysMenu 菜单实体
     * @return ajaxData
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult insertMenu(SysMenu sysMenu) {
        //暂时使用
        sysMenu.setCreateBy(UserUtil.getUserNo());
        return toAjax(menuServices.insertEntity(sysMenu));
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        List<SysMenu> sysMenus = menuServices.selectListToExcel();
        EasyExcelUtils.exportExcel(response, sysMenus, "sheet1", ExcelTypeEnum.XLSX);
    }
}
