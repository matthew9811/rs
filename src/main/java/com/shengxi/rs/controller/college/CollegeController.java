package com.shengxi.rs.controller.college;


import com.shengxi.rs.common.domain.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubOptToolEntity;
import com.shengxi.system.model.service.sub.SubOptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @author 郑杰
 * @date 2019/3/25 01:50
 * 学院审批页跳转
 */
@Controller
@RequestMapping("/college/college")
public class CollegeController extends BaseController {
    private String prefix = "college";

    @Autowired
    private SubOptServices subOptServices;

    @GetMapping("/classBegins")
    public String classbegins() {
        return prefix + "/classBegins";
    }

    @GetMapping("/subordinate")
    public String subordinate() {
        return prefix + "/subordinate";
    }

    @RequestMapping("/subordinateList")
    @ResponseBody
    public TableDataInfo subordinateList(SubOptEntity subOptEntity,String status) {
        startPage();
        List<SubOptToolEntity> list = subOptServices.selectSubStuList("1626943763580391424",status);
        return getDataTable(list);
    }

    @RequestMapping("/classBeginsList")
    @ResponseBody
    public TableDataInfo classBeginsList(SubOptEntity subOptEntity,String status) {
        startPage();
        List<SubOptToolEntity> list = subOptServices.selectSubStuList("1626943763580391424",status);
        return getDataTable(list);
    }

    @RequestMapping("/updateClassBegins")
    @ResponseBody
    public Integer updateClassBegins(SubOptEntity subOptEntity, String id, String status, String instituteRemark) {
        subOptEntity.setId(id);
        subOptEntity.setStatus(status);
        subOptEntity.setInstituteRemark(instituteRemark);
        Integer result = subOptServices.updateByStuOpt(subOptEntity);
        return result;
    }

}
