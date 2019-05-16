package com.shengxi.rs.controller.college;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.sys.SysDeptEntity;
import com.shengxi.system.model.service.sub.SubOptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 郑杰
 * @date 2019/3/25 01:50
 * 学院审批页跳转
 */
@Controller
@RequestMapping("/college/college")
public class CollegeController {
    private String prefix = "college";

    @Autowired
    private SubOptServices subOptServices;

    @GetMapping("/classBegins")
    public String classbegins(Model model,String status,String id) {
        if(ObjectUtil.isNotNull(status)){
           subOptServices.updateByStuOpt(status,id);
        }
        List<SubOptEntity> list = subOptServices.selectSubStuList("0");
        model.addAttribute("list",list);
        return prefix + "/classBegins";
    }

    @GetMapping("/subordinate")
    public String subordinate(Model model) {
        List<SubOptEntity> list = subOptServices.selectSubStuList("5");
        model.addAttribute("list",list);
        return prefix + "/subordinate";
    }
}
