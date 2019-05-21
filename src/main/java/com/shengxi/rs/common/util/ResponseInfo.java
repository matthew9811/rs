package com.shengxi.rs.common.util;

import java.io.Serializable;

/**
 * 响应支撑类
 *
 * @author matthew
 */
public class ResponseInfo implements Serializable {

    private String code;
    private String message;

    public ResponseInfo() {
    }

    public ResponseInfo(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
