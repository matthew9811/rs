package com.shengxi.system.entites.pay;

/**
 * @author matthew
 * @date 2019年7月31日 11:57:25
 * ali支付实体类
 */

public class Alipay {

    /**商户订单号，必填*/
    private String outTradeNo;
    /**订单名称，必填*/
    private String subject;
    /**付款金额，必填*/
    private StringBuffer totalAmount;
    /**商品描述，可空*/
    private String body;
    /**超时时间参数*/
    private String timeoutExpress = "10m";
    private String productCode = "FAST_INSTANT_TRADE_PAY";

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public StringBuffer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(StringBuffer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
