package com.shengxi.rs.controller.sys;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.shengxi.rs.common.annotation.Log;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.file.excel.EasyExcelUtils;
import com.shengxi.rs.common.util.web.AjaxResult;
import com.shengxi.rs.common.util.UserUtil;
import com.shengxi.system.entites.sys.SysMenu;
import com.shengxi.system.model.service.sys.SysMenuService;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author matthew
 * @Description: 菜单管理
 * @Date: 2019年6月24日 15:46:47
 * @see com.shengxi.rs.common.handler.BaseController
 */
@Controller
@RequestMapping("/admin/menu")
@Log("MenuController")
public class MenuController extends BaseController {

    private String prefix = "/admin/menu";


    private SysMenuService menuServices;

    @Autowired
    public void setMenuServices(SysMenuService menuServices) {
        this.menuServices = menuServices;
    }
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
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap map) {
        map.put("parentList", menuServices.selectOfParentAdd());
        return prefix + "/add";
    }

    /**
     * 编辑菜单
     *
     * @param map model
     * @return url
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map) {
        map.put("parentList", menuServices.selectOfParentAdd());
        map.put("menu", menuServices.selectMenuById(id));
        return prefix + "/edit";
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
        List<SysMenu> sysMenus = menuServices.selectByList();
        EasyExcelUtils.exportExcel(response, sysMenus, "sheet1", ExcelTypeEnum.XLSX);
    }
}
