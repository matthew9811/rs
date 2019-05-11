package com.shengxi.rs.controller.test;

import afu.org.checkerframework.checker.oigj.qual.O;
import com.shengxi.rs.controller.sys.BaseController;
import com.shengxi.system.entites.test.TestEntity;
import com.shengxi.system.entites.test.TestStu;
import com.shengxi.system.model.service.test.TestServices;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Matthew
 * @Date: 2019/3/14 17:00
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
    private String prefix = "test";

    @Autowired
    private TestServices testServices;

    @RequestMapping("")
    public String test() {
        return prefix + "/index";
    }

    @GetMapping("/input")
    public String input() {
        return prefix + "/inputTest";
    }

    @PostMapping("/input")
    @ResponseBody
    public List<TestEntity> input(TestEntity entity) {
        System.out.println(entity.toString());
        System.out.println("---------------------");
        List<TestEntity> list = testServices.selectList();
        return list;
    }

    @GetMapping("/main")
    public String main(HttpServletResponse response) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "main";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public Map<String, Object> getList() {
        List<TestStu> list = new ArrayList<>();
        TestStu stu = new TestStu();
        stu.setSubNo("CS1007");
        stu.setSubName("线性代数");
        stu.setTerm("2017-2018-1");
        stu.setChoiceStatus("0");
        stu.setRemark("这是备注这是备注这是备注");
        stu.setGrade(59.5);
        list.add(stu);
        Map<String, Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg", "200");
        map.put("count", 5);
        map.put("data", list);
        return map;
    }


}
