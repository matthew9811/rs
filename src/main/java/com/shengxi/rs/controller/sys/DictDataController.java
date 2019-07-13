package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.domain.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.web.AjaxResult;
import com.shengxi.system.common.constant.BaseConstant;
import com.shengxi.system.entites.sys.SysData;
import com.shengxi.system.model.service.sys.SysDictDataService;
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
 * @version 1.0.0
 * @date 2019.06.09
 * @Description: 字典数据控制器
 * @see DictDataController
 */
@RequestMapping("/admin/dictData")
@Controller
public class DictDataController extends BaseController {
    private String prefix = "/admin/dict/dictData";

    private SysDictDataService dictDataService;

    @Autowired
    public DictDataController(SysDictDataService dictDataService) {
        this.dictDataService = dictDataService;
    }

    @GetMapping("/{typeNo}")
    public String dictDataDetail(@PathVariable("typeNo") String typeNo, ModelMap map) {
        map.addAttribute("typeNo", typeNo);
        return prefix + "/dictData";
    }

    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo dictDataDetail(SysData sysData) {
        return getDataTable(dictDataService.selectDictDataListByDictId(sysData));
    }

    @GetMapping("/add/{typeNo}")
    public String add(@PathVariable("typeNo") String typeNo, ModelMap map) {
        map.addAttribute("typeNo", typeNo);
        return prefix + "/add";
    }

    @PutMapping("/add")
    public AjaxResult addSave(SysData sysData) {
        sysData.setDelFlag(BaseConstant.DEL_FLAG_NOT);
        return toAjax(dictDataService.insert(sysData));
    }
}
