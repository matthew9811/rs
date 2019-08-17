package com.shengxi.rs.controller.test;

import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.model.service.test.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2019.05.12
 * @author chuling
 */
@RequestMapping("/test/page")
@Controller
public class PageController extends BaseController {

    @Autowired
    private TestServices testServices;


    @GetMapping("/index")
    public String jumpIndex(){
        return "/index";
    }

}
