package com.shengxi.rs.controller.sys;

import com.shengxi.system.entity.config.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.common.util.web.AjaxResult;
import com.shengxi.system.entity.sys.SysDict;
import com.shengxi.system.model.service.sys.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 字典类控制层
 *
 * @author matthew
 * @version 1.0.0
 * @date 2019.06.07
 */
@Controller
@RequestMapping("/admin/dict")
public class DictController extends BaseController {

    private SysDictService sysDictService;

    private String prefix = "/admin/dict";

    @GetMapping()
    public String dict() {
        return prefix + "/dict";
    }

    @ResponseBody
    @RequestMapping("/list")
    public TableDataInfo dict(SysDict sysDict) {
        startPage();
        return getDataTable(sysDictService.selectSysDictList(sysDict));
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public AjaxResult addSave(SysDict sysDict) {
        return toAjax(sysDictService.insertSysDict(sysDict));
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") String id, ModelMap map) {
        map.put("dict", sysDictService.selectSysDictById(id));
        return prefix + "/edit";
    }

    @ResponseBody
    @PutMapping("/edit")
    public AjaxResult editSave(SysDict sysDict) {
        return toAjax(sysDictService.updateByIdSelective(sysDict));
    }

    /**
     * update dict status
     *
     * @param sysDict bean
     * @return status and msg
     */
    @ResponseBody
    @PutMapping("/update")
    public AjaxResult autoUpdate(SysDict sysDict) {
        return toAjax(sysDictService.updateByIdSelective(sysDict));
    }


    @ResponseBody
    @DeleteMapping("/move/{id}")
    public AjaxResult move(@PathVariable String id) {
        return toAjax(sysDictService.deleteSysDictById(id));
    }


    @ResponseBody
    @DeleteMapping("/moveList")
    public AjaxResult moveList(String ids) {
        return toAjax(sysDictService.deleteSysDictByIds(ids));
    }

    @Autowired
    public DictController(SysDictService sysDictService) {
        this.sysDictService = sysDictService;
    }
}
