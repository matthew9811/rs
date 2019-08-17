package com.shengxi.rs.controller.test;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.system.common.util.UserUtil;
import com.shengxi.system.common.util.file.excel.EasyExcelUtils;
import com.shengxi.system.common.util.SecurityUserUtil;
import com.shengxi.system.entity.test.ExportInfo;
import com.shengxi.system.entity.test.TestEntity;
import com.shengxi.system.model.service.test.TestServices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public List<Object> input(TestEntity entity) {
        List<Object> list = new ArrayList<>();
        list.addAll(testServices.selectList());
        list.add(SecurityUserUtil.getCurrentUserAuthentication().getDetails());
        return list;
    }

    @GetMapping("/test")
    public String main(HttpServletResponse response) {
        System.out.println(UserUtil.getLoginUser());
        return prefix + "/table";
    }


    /**
     * 导出 Excel（一个 sheet）
     */
    @RequestMapping(value = "/writeExcel", method = RequestMethod.GET)
    public void writeExcel(HttpServletResponse response) throws IOException {
        List<ExportInfo> list = getList();
        String fileName = "一个 Excel 文件";
        String sheetName = "第一个 sheet.xls";
        Map<String, List<? extends BaseRowModel>> map = new HashMap<>(1);
        map.put(fileName, list);
        EasyExcelUtils.exportExcelMultipleEasyExcel(response, map, ExcelTypeEnum.XLSX);
    }

    private List<ExportInfo> getList() {
        List<ExportInfo> list = new ArrayList<>();
        ExportInfo model1 = new ExportInfo();
        model1.setName("howie");
        model1.setAge("19");
        model1.setAddress("123456789");
        model1.setEmail("123456789@gmail.com");
        list.add(model1);
        ExportInfo model2 = new ExportInfo();
        model2.setName("harry");
        model2.setAge("20");
        model2.setAddress("198752233");
        model2.setEmail("198752233@gmail.com");
        list.add(model2);
        return list;
    }


}
