package com.shengxi.rs.controller.college;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.rs.common.domain.TableDataInfo;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.entites.subEntity.SubOptEntity;
import com.shengxi.system.entites.subEntity.SubOptToolEntity;
import com.shengxi.system.entites.subEntity.SubjectEntity;
import com.shengxi.system.entites.sys.SysDeptEntity;
import com.shengxi.system.model.service.sub.SubOptServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String classbegins(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return prefix + "/classBegins";
    }

    @GetMapping("/subordinate")
    public String subordinate(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return prefix + "/subordinate";
    }

    @RequestMapping("/subordinateList")
    @ResponseBody
    public TableDataInfo subordinateList(SubOptEntity subOptEntity) {
        startPage();
        List<SubOptToolEntity> list = subOptServices.selectSubStuList("5");
        return getDataTable(list);
    }

    @RequestMapping("/classBeginsList")
    @ResponseBody
    public TableDataInfo classBeginsList(SubOptEntity subOptEntity, HttpServletRequest request) {
        System.out.println(request.getParameter("id"));
        subOptServices.updateByStuOpt(request.getParameter("id"),request.getParameter("status"));
        startPage();
        List<SubOptToolEntity> list = subOptServices.selectSubStuList("5");
        return getDataTable(list);
    }

}
