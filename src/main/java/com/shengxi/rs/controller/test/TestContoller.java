package com.shengxi.rs.controller.test;

import com.shengxi.rs.controller.sys.BaseController;
import com.shengxi.system.entites.test.TestEntity;
import com.shengxi.system.model.service.test.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Matthew
 * @Date: 2019/3/14 17:00
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class TestContoller extends BaseController {
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
    public String main(){
        return "main";
    }


}
