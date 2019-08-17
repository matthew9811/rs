package com.shengxi.rs.common.config;

import com.shengxi.system.entity.config.ValidateCodeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * @author: Matthew
 * @Date: 2019/4/6 21:43
 * @Description:
 */

@Configuration
@ConfigurationProperties(prefix = "rs")
public class RsProperties {

    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

    private String timeFormat = "yyyy-MM-dd HH:mm:ss";

    private boolean openAopLog = true;


    public ValidateCodeProperties getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(ValidateCodeProperties validateCode) {
        this.validateCode = validateCode;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public boolean isOpenAopLog() {
        return openAopLog;
    }

    public void setOpenAopLog(boolean openAopLog) {
        this.openAopLog = openAopLog;
    }
}
