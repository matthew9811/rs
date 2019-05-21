package com.shengxi.rs.controller.add;

import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.IdUtil;
import com.shengxi.system.entites.subEntity.ComSubEntity;
import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubReplaceEntity;
import com.shengxi.system.entites.subEntity.SubjectEntity;

import com.shengxi.system.entites.sys.SysDeptEntity;
import com.shengxi.system.model.mapper.sys.SysDeptMapper;
import com.shengxi.system.model.service.sub.ComSubServices;
import com.shengxi.system.model.service.sub.SubOptServices;
import com.shengxi.system.model.service.sub.SubReplaceServices;
import com.shengxi.system.model.service.sub.SubjectServices;

import com.shengxi.system.model.service.sys.SysDeptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * @author 郑杰
 * @date  2019/3/25 10:25
 * 添加数据
 */
@Controller
@RequestMapping("/add/add")
public class AddController extends BaseController {
    private String prefix = "add";

    @Autowired
    private SubjectServices subjectServices;

    @Autowired
    private ComSubServices comSubServices;

    @Autowired
    private SubOptServices subOptServices;

    @Autowired
    private SubReplaceServices subReplaceServices;

    @Autowired
    private SysDeptServices sysDeptServices;

    @GetMapping("/addSubject")
    public String addSubject() {
        return prefix + "/addSubject";

    }
    @GetMapping("/addComSub")
    public String addComSub() {
        return prefix + "/addComSub";

    }
    @GetMapping("/addSubOpt")
    public String addSubOpt() {
        return prefix + "/addSubOpt";

    }
    @GetMapping("/addSubReplace")
    public String addSubReplace() {
        return prefix + "/addSubReplace";

    }
    @GetMapping("/addSysDept")
    public String addSysDept() {
        return prefix + "/addSysDept";

    }
    @PostMapping("/addSubject")
    @ResponseBody
    public List<SubjectEntity> addSubject(SubjectEntity subjectEntity) {
       subjectEntity.setId(IdUtil.uuid());
       subjectServices.addList(subjectEntity);
       List<SubjectEntity> list = subjectServices.selectList(subjectEntity);
       return list;
    }
    @PostMapping("/addComSub")
    @ResponseBody
    public List<ComSubEntity> addComSub(ComSubEntity comSubEntity) {
        comSubEntity.setId(IdUtil.uuid());
        comSubServices.addList(comSubEntity);
        List<ComSubEntity> list =comSubServices.selectList(comSubEntity);
        return list;
    }
    @PostMapping("/addSubOpt")
    @ResponseBody
    public List<SubOptEntity> addSubject(SubOptEntity subOptEntity) {
        subOptEntity.setId(IdUtil.uuid());
        subOptServices.addList(subOptEntity);
        List<SubOptEntity> list = subOptServices.selectList(subOptEntity);
        return list;
    }
    @PostMapping("/addSubReplace")
    @ResponseBody
    public ModelAndView addReplace(SubReplaceEntity subReplaceEntity) {
        subReplaceEntity.setId(IdUtil.uuid());
        subReplaceServices.addList(subReplaceEntity);
        List<SubReplaceEntity> list = subReplaceServices.selectList(subReplaceEntity);
        ModelAndView modelAndView = new ModelAndView("redirect:/academic/academic/replace");
        return modelAndView;
    }
    @PostMapping("/addSysDept")
    @ResponseBody
    public List<SysDeptEntity> addSubject(SysDeptEntity sysDeptEntity) {
        sysDeptEntity.setId(IdUtil.uuid());
        sysDeptServices.addList(sysDeptEntity);
        List<SysDeptEntity> list = sysDeptServices.selectList(sysDeptEntity);
        return list;
    }
}
