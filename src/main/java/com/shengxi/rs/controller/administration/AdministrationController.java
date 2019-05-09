package com.shengxi.rs.controller.administration;

import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.model.service.sub.SubOptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 郑杰
 * @date  2019/3/25 10:25
 * 教务审批跳转
 */
@Controller
@RequestMapping("/administration/administration")
public class AdministrationController {
    private  String prefix = "administration";

    @Autowired
    private SubOptServices subOptServices;

    @GetMapping("/approval")
    public String approval(Model model, String status, String id) {
        if(status!=null){
            subOptServices.updateByStuOpt(status,id);
        }
        List<SubOptEntity> list = subOptServices.selectSubStuList("1");
        model.addAttribute("list",list);
        return prefix + "/approval";
    }

    @GetMapping("/replace")
    public String replace() {
        return prefix + "/replace";
    }
    @GetMapping("/upload")
    public String upload() {
        return prefix + "/upload";


    }
}
