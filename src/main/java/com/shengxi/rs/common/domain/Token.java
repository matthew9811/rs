package com.shengxi.rs.common.domain;

import java.io.Serializable;

/**
 * token管理
 * @date 2019.05.15
 * @author matthew
 */
public class Token implements Serializable {
    private String token;

    private Long loginTime;

    public Token() {
    }

    public Token(String token, Long loginTime) {
        super();
        this.token = token;
        this.loginTime = loginTime;
    }
}
