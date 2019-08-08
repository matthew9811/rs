package com.shengxi.rs.common.util.pay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.shengxi.rs.common.config.AlipayConfig;
import com.shengxi.system.entites.pay.Alipay;


/**
 * @author matthew
 */
public class AlipayUtil {
    public static String connect(Alipay alipay) throws AlipayApiException {
        //1、获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.getKey("gatewayUrl"),
                AlipayConfig.getKey("app_id"),
                AlipayConfig.getKey("merchant_private_key"),
                "json",
                AlipayConfig.getKey("charset"),
                AlipayConfig.getKey("alipay_public_key"),
                AlipayConfig.getKey("sign_type")
        );
        //2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(AlipayConfig.getKey("return_url"));
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl("notify_url");
        //封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipay));

        //3、请求支付宝进行付款，并获取支付结果
        return alipayClient.pageExecute(alipayRequest).getBody();
    }
}
