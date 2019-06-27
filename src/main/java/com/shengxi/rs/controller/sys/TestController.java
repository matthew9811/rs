package com.shengxi.rs.controller.sys;

import com.shengxi.rs.common.handler.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/test")
public class TestController extends BaseController {

    private String prefix = "/test";

    /**
     * 直接进入页面
     *
     * @return .html
     */
    @GetMapping
    public String index() {
        return prefix + "/test";
    }
}
