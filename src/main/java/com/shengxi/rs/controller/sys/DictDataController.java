package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.model.service.sys.SysDictDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author matthew
 * @version 1.0.0
 * @date 2019.06.09
 * @Description: 字典数据控制器
 * @see DictDataController
 */
@RequestMapping("/dictData")
@Controller
public class DictDataController extends BaseController {
    private String prefix = "/admin/dictData";

    private SysDictDataService dictDataService;

    public DictDataController(SysDictDataService dictDataService) {
        this.dictDataService = dictDataService;
    }
    
    
    
}
