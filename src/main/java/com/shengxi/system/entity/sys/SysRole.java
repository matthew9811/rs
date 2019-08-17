package com.shengxi.system.entity.sys;

import com.shengxi.system.entity.config.BaseEntity;

/**
 * @author: Matthew
 * @Date: 2019/5/5 11:19
 * @Description:
 */
public class SysRole extends BaseEntity {


    private String userName;

    public SysRole() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
