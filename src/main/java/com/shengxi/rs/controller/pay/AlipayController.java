package com.shengxi.rs.controller.pay;

import com.alipay.api.AlipayApiException;
import com.shengxi.rs.common.handler.BaseController;
import com.shengxi.rs.common.util.web.AjaxResult;
import com.shengxi.system.entites.pay.Alipay;
import com.shengxi.system.model.service.pay.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pay/ali")
public class AlipayController extends BaseController {
    private String prefix = "/pay/alipay";

    private AlipayService alipayService;


    @GetMapping("/alipay")
    public String aliPay() {
        return prefix.concat("/alipay");
    }

    @PostMapping("/alipay")
    @ResponseBody
    public String alipay(Alipay alipay) {
        String payResult = null;
        try {
            payResult = alipayService.aliPay(alipay);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return payResult;
    }


    @GetMapping("/success")
    public String successUrl(){
        return "/";
    }

    @GetMapping("/error")
    public String errorUrl(){
        return "/";
    }

    @Autowired
    public void setAlipayService(AlipayService alipayService) {
        this.alipayService = alipayService;
    }
}
