package com.shengxi.rs.controller.stu;

import cn.hutool.core.util.ObjectUtil;

import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.system.entites.subEntity.ComSubEntity;
import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubjectEntity;
import com.shengxi.system.entites.sys.SysUser;
import com.shengxi.system.model.mapper.sys.SysUserMapper;
import com.shengxi.system.model.service.sub.ComSubServices;
import com.shengxi.system.model.service.sub.SubOptServices;
import com.shengxi.system.model.service.sub.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 郑杰
 * @date 2019/3/24 16:17
 * 学生申请表接受跳转
 */
@Controller
@RequestMapping("/stu/stu")
public class StuController {

    private String prefix = "stu";

    @Autowired
    private SubjectServices subjectServices;

    @Autowired
    private ComSubServices comSubServices;

    @Autowired
    private SubOptServices subOptServices;

    @Autowired
    private SysUserMapper sysUserMapper;

    @PostMapping("/news")
    public String pnews() {

        return "redirect:/stu/stu/news";
    }
    @PostMapping("/course")
    public String pcourse() {
        return "redirect:/stu/stu/course";
    }
    @PostMapping("/choose")
    public String pchoose() {
        return "redirect:/stu/stu/choose";
    }

    @GetMapping("/course")
    public String course(Model model,String subCarryNo) {
        List<SubjectEntity> list = subjectServices.souSubjectEntityList(subCarryNo);
//        SysUser sysUser = userService.selectUserNo("17210210613");

        for(SubjectEntity subjectEntity : list){
            model.addAttribute("subjectEntity",subjectEntity);
        }
//        model.addAttribute("sysUser",sysUser);
        return prefix + "/course";
    }

    @GetMapping("/news")
    public String news(Model model,String subCarryNo,String subName) {
        SubOptEntity subOptEntity = new SubOptEntity();
        subOptEntity.setId(IdUtil.uuid());
        subOptEntity.setStuNo("17210210613");
        subOptEntity.setSubId(subCarryNo);
        subOptEntity.setSubName(subName);
        subOptEntity.setStatus("0");
        if(ObjectUtil.isNotNull(subCarryNo)) {
            subOptServices.addList(subOptEntity);
        }
        List<SubOptEntity> list = subOptServices.selectList(subOptEntity);
        model.addAttribute("list",list);
        return prefix + "/news";
    }
    @GetMapping("/search")
    public String search(Model model) {
        ComSubEntity comSubEntity = new ComSubEntity();
        comSubEntity.setStuNo("17210210613");
        List<ComSubEntity> list = comSubServices.selectList(comSubEntity);
        model.addAttribute("list",list);
        return prefix + "/search";
    }

    @GetMapping("/choose")
    public String choose(Model model,String subNo) {
        List<SubjectEntity> list = subjectServices.souSubjectEntityList(subNo);
        model.addAttribute("list",list);
        return prefix + "/choose";
    }

    @RequestMapping("")
    public String test() {
        return "/test/index";
    }

    @PostMapping("/sou")
    @ResponseBody
    public String souSubject(String sou,Model model) {
        List<SubjectEntity> list = subjectServices.souSubjectEntityList(sou);
        return prefix + "/choose";
    }
}
