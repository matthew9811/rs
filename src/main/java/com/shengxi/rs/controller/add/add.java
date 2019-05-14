package com.shengxi.rs.controller.add;

import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.system.entites.subEntity.ComSubEntity;
import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.entites.subEntity.SubjectEntity;

import com.shengxi.system.model.service.sub.ComSubServices;
import com.shengxi.system.model.service.sub.SubOptServices;
import com.shengxi.system.model.service.sub.SubReplaceServices;
import com.shengxi.system.model.service.sub.SubjectServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/add/add")
public class add {
    private String prifix = "add";

    @Autowired
    private SubjectServices subjectServices;

    @Autowired
    private ComSubServices comSubServices;

    @Autowired
    private SubOptServices subOptServices;

    @Autowired
    private SubReplaceServices subReplaceServices;

    @GetMapping("/addSubject")
    public String addSubject() {
        return prifix + "/addSubject";

    }
    @GetMapping("/addComSub")
    public String addComSub() {
        return prifix + "/addComSub";

    }
    @GetMapping("/addSubOpt")
    public String addSubOpt() {
        return prifix + "/addSubOpt";

    }
    @GetMapping("/addSubReplace")
    public String addSubReplace() {
        return prifix + "/addSubReplace";

    }
    @PostMapping("/addSubject")
    @ResponseBody
    public List<SubjectEntity> addSubject(SubjectEntity subjectEntity) {
       System.out.println(subjectEntity.toString());
       subjectEntity.setId(IdUtil.uuid());
        Integer result = subjectServices.addList(subjectEntity);
        System.out.println(result);
       List<SubjectEntity> list = subjectServices.selectList(subjectEntity);
       return list;
    }
    @PostMapping("/addComSub")
    @ResponseBody
    public List<ComSubEntity> addComSub(ComSubEntity comSubEntity) {
        System.out.println(comSubEntity.toString());
        comSubEntity.setId(IdUtil.uuid());
        Integer result = comSubServices.addList(comSubEntity);
        System.out.println(result);
        List<ComSubEntity> list =comSubServices.selectList(comSubEntity);
        return list;
    }
    @PostMapping("/addSubOpt")
    @ResponseBody
    public List<SubOptEntity> addSubject(SubOptEntity subOptEntity) {
        System.out.println(subOptEntity.toString());
        subOptEntity.setId(IdUtil.uuid());
        Integer result = subOptServices.addList(subOptEntity);
        System.out.println(result);
        List<SubOptEntity> list = subOptServices.selectList(subOptEntity);
        return list;
    }
    @PostMapping("/addSubReplace")
    @ResponseBody
    public ModelAndView addSubject(SubReplaceEntity subReplaceEntity) {
        System.out.println(subReplaceEntity.toString());
        subReplaceEntity.setId(IdUtil.uuid());
        Integer result = subReplaceServices.addList(subReplaceEntity);
        System.out.println(result);
        List<SubReplaceEntity> list = subReplaceServices.selectList(subReplaceEntity);
        ModelAndView modelAndView = new ModelAndView("redirect:/academic/academic/replace");
        return modelAndView;
    }
}
