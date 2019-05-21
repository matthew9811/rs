package com.shengxi.rs.controller.stu;

import cn.hutool.core.util.ObjectUtil;

import com.shengxi.rs.common.domain.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 郑杰
 * @date 2019/3/24 16:17
 * 学生申请表接受跳转
 */
@Controller
@RequestMapping("/stu/stu")
public class StuController extends BaseController {

    private String prefix = "stu";

    @Autowired
    private SubjectServices subjectServices;

    @Autowired
    private ComSubServices comSubServices;

    @Autowired
    private SubOptServices subOptServices;

    @Autowired
    private SysUserMapper sysUserMapper;


    @GetMapping("/course")
    public String course(Model model,String subCarryNo) {

        List<SubjectEntity> list = subjectServices.souSubjectEntityList("1068525");
        SysUser sysUser = new SysUser();
        sysUser.setUserNo("17210210613");
        sysUser = sysUserMapper.selectUserNo(sysUser);
        for(SubjectEntity subjectEntity : list){
            model.addAttribute("subjectEntity",subjectEntity);
        }
        model.addAttribute("sysUser",sysUser);
        return prefix + "/course";
    }

    @GetMapping("/news")
    public String news(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return prefix + "/news";

        /**SubOptEntity subOptEntity = new SubOptEntity();
        subOptEntity.setId(IdUtil.uuid());
        subOptEntity.setStuNo("17210210613");
        subOptEntity.setSubId(subCarryNo);
        subOptEntity.setSubName(subName);
        subOptEntity.setStatus("0");
        if(ObjectUtil.isNotNull(subCarryNo)) {
            subOptServices.addList(subOptEntity);
        }
        SubOptEntity subOptEntity1 = new SubOptEntity();
        subOptEntity1.setStuNo("17210210613");
        List<SubOptEntity> list = subOptServices.selectList(subOptEntity1);
        model.addAttribute("list",list);
        return prefix + "/news";
         */
    }
    @GetMapping("/search")
    public String search(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return prefix + "/search";
    }

    @GetMapping("/choose")
    public String choose(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return prefix + "/choose";
    }

    @PostMapping("/sou")
    @ResponseBody
    public ModelAndView souSubject(String sou, Model model) {
        List<SubjectEntity> list = subjectServices.souSubjectEntityList(sou);
        model.addAttribute("list",list);
        ModelAndView modelAndView = new ModelAndView("redirect:/stu/stu/choose");
        return modelAndView;
    }
    @RequestMapping("/newsList")
    @ResponseBody
    public TableDataInfo newsList(SubOptEntity subOptEntity) {
        subOptEntity.setStuNo("17210210613");
        startPage();
        List<SubOptEntity> list = subOptServices.selectList(subOptEntity);
        return getDataTable(list);
    }

    @RequestMapping("/chooseList")
    @ResponseBody
    public TableDataInfo chooseList(SubjectEntity subjectEntity, HttpServletRequest request) {
        request.getParameter("subNo");
        System.out.println("2");
        System.out.println("subNo");
        subjectEntity.setSubCarryNo("1068515");
        startPage();
        List<SubjectEntity> list = subjectServices.selectList(subjectEntity);
        return getDataTable(list);
    }

    @RequestMapping("/searchList")
    @ResponseBody
    public TableDataInfo searchList(ComSubEntity comSubEntity) {
        comSubEntity.setStuNo("17210210613");
        startPage();
        List<ComSubEntity> list = comSubServices.selectList(comSubEntity);
        return getDataTable(list);
    }
}
