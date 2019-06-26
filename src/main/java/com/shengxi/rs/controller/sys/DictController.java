package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.domain.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.web.AjaxResult;
import com.shengxi.system.common.constant.BaseConstant;
import com.shengxi.system.entites.sys.SysDict;
import com.shengxi.system.model.service.sys.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典类控制层
 *
 * @author matthew
 * @version 1.0.0
 * @date 2019.06.07
 */
@RequestMapping("/admin/dict")
@Controller
public class DictController extends BaseController {

    final private SysDictService sysDictService;

    private String prefix = "/admin/dict";

    @Autowired
    public DictController(SysDictService sysDictService) {
        this.sysDictService = sysDictService;
    }

    @GetMapping()
    public String dict() {
        return prefix + "/dict";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo dict(SysDict sysDict) {
        startPage();
        return getDataTable(sysDictService.selectSysDictList(sysDict));
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysDict sysDict) {
        sysDict.setDelFlag(BaseConstant.DEL_FLAG_NOT);
        return toAjax(sysDictService.insertSysDict(sysDict));
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") String id, ModelMap map) {
        map.put("dict", sysDictService.selectSysDictById(id));
        return prefix + "edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysDict sysDict) {
        return toAjax(sysDictService.updateByIdSelective(sysDict));
    }
    
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String id){
        return toAjax(sysDictService.deleteSysDictById(id));
    }
    
    @DeleteMapping("/removeList")
    @ResponseBody
    public AjaxResult removeList(String ids){
        return toAjax(sysDictService.deleteSysDictByIds(ids));
    }

}
