package com.shengxi.system.model.service.pay.impl;

import com.alipay.api.AlipayApiException;
import com.shengxi.rs.common.util.pay.AlipayUtil;
import com.shengxi.system.entites.pay.Alipay;
import com.shengxi.system.model.service.pay.AlipayService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author matthew
 */
@Primary
@Service(value = "alipay")
public class AlipayServiceImpl implements AlipayService {
    @Override
    public String aliPay(Alipay alipay) throws AlipayApiException {
        return AlipayUtil.connect(alipay);
    }
}
