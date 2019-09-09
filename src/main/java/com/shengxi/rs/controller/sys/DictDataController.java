package com.shengxi.rs.controller.sys;

import com.shengxi.system.entity.config.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.common.util.web.AjaxResult;
import com.shengxi.system.common.constant.BaseConstant;
import com.shengxi.system.entity.sys.SysData;
import com.shengxi.system.model.service.sys.SysDictDataService;
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
 * @author matthew
 * @version 1.0.0
 * @date 2019.06.09
 * @Description: 字典数据控制器
 * @see DictDataController
 */
@Controller
@RequestMapping("/admin/dictData")
public class DictDataController extends BaseController {

    private String prefix = "/admin/dict/dictData";

    private SysDictDataService dictDataService;


    /**
     * 获取详情，跳转到对应的页面
     * @param typeNo typeNo
     * @param map map
     * @return html ? data = typeNo
     */
    @GetMapping("/{typeNo}")
    public String dictDataDetail(@PathVariable("typeNo") String typeNo, ModelMap map) {
        map.addAttribute("typeNo", typeNo);
        return prefix + "/dictData";
    }

    /**
     * 获取列表
     * @param sysData sysData搜索条件
     * @return list
     */
    @ResponseBody
    @PostMapping("/list")
    public TableDataInfo dictDataDetail(SysData sysData) {
        return getDataTable(dictDataService.selectDictDataListByDictId(sysData));
    }

    /**
     * 跳转到添加页面
     * @param typeNo typeNo
     * @param map map
     * @return html?data=typeNo
     */
    @GetMapping("/add/{typeNo}")
    public String add(@PathVariable("typeNo") String typeNo, ModelMap map) {
        map.addAttribute("typeNo", typeNo);
        return prefix + "/add";
    }

    /**
     * 获取html输入的对象，通过验证保存在数据库、
     * 不通过，返回对应的提示信息.
     * @param sysData record
     * @return msg and status code
     */
    @ResponseBody
    @PostMapping("/add")
    public AjaxResult addSave(SysData sysData) {
        sysData.setDelFlag(BaseConstant.DEL_FLAG_NOT);
        return toAjax(dictDataService.insert(sysData));
    }

    @ResponseBody
    @PutMapping("/update")
    public AjaxResult autoUpdate(SysData sysData){
        return toAjax(dictDataService.updateByTypeCodeSelective(sysData));
    }


    /**
     * delete selected data in typeNO
     * @param typeNo typeNo
     * @return status and msg
     */
    @ResponseBody
    @DeleteMapping("/move/{typeNo}")
    public AjaxResult move(@PathVariable String typeNo) {
        return toAjax(dictDataService.deleteByTypeNo(typeNo));
    }


    @Autowired
    public void setDictDataService(SysDictDataService dictDataService) {
        this.dictDataService = dictDataService;
    }
}
