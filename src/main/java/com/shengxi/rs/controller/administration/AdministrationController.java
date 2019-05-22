package com.shengxi.rs.controller.administration;

import com.shengxi.rs.common.domain.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubOptToolEntity;
import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.model.service.sub.SubOptServices;
import com.shengxi.system.model.service.sub.SubReplaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 郑杰
 * @date  2019/3/25 10:25
 * 教务审批跳转
 */
@Controller
@RequestMapping("/academic/academic")
public class AdministrationController extends BaseController {
    private  String prefix = "academic";

    @Autowired
    private SubOptServices subOptServices;
    @Autowired
    private SubReplaceServices subReplaceServices;

    @GetMapping("/approval")
    public String approval(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return prefix + "/approval";
    }

    @RequestMapping("/approvalList")
    @ResponseBody
    public TableDataInfo approvaList(SubOptEntity subOptEntity, HttpServletRequest request) {
        subOptServices.updateByStuOpt(request.getParameter("id"),request.getParameter("status"));
        startPage();
        List<SubOptToolEntity> list = subOptServices.selectSubStuList("5");
        return getDataTable(list);
    }

    @GetMapping("/replace")
    public String replace(Model model, String subNo, String subReplaceNo) {
        SubReplaceEntity subReplaceEntity = new SubReplaceEntity();
        subReplaceEntity.setSubNo(subNo);
        subReplaceEntity.setSubReplaceNo(subReplaceNo);
        List<SubReplaceEntity> list = subReplaceServices.selectList(subReplaceEntity);
        model.addAttribute("list",list);
        return prefix + "/replace";
    }

    @GetMapping("/upReplace")
    public String upReplace(Model model, String Id) {
        SubReplaceEntity subReplaceEntity = new SubReplaceEntity();
        subReplaceEntity.setId(Id);
        List<SubReplaceEntity> list = subReplaceServices.selectList(subReplaceEntity);
        for(SubReplaceEntity subReplaceEntity1 : list){
            model.addAttribute("subReplaceEntity",subReplaceEntity1);
        }
        return prefix + "/upReplace";
    }

    @PostMapping("/upReplace")
    @ResponseBody
    public ModelAndView upReplace(SubReplaceEntity subReplaceEntity) {
        subReplaceServices.updateBySubReplaceEntityList(subReplaceEntity);
        ModelAndView modelAndView = new ModelAndView("redirect:/academic/academic/replace");
        return modelAndView;
    }
    @GetMapping("/upload")
    public String upload() {
        return prefix + "/upload";


    }
}
