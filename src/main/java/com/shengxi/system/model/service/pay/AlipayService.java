package com.shengxi.system.model.service.pay;


import com.alipay.api.AlipayApiException;
import com.shengxi.system.entites.pay.Alipay;


/**
 * ali支付服务层接口
 * @author matthew
 */
public interface AlipayService {
    /**
     * 进行阿里支付沙箱api调用
     * @param alipay pojo
     * @return html
     * @throws AlipayApiException exception
     */
    String aliPay(Alipay alipay) throws AlipayApiException;
}
