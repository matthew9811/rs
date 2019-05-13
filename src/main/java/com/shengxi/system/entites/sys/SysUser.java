package com.shengxi.system.entites.sys;

import com.shengxi.rs.common.domain.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_user
 *
 * @mbg.generated do_not_delete_during_merge
 * @author 梁焰豪
 * @date 2019.05.12
 */
public class SysUser extends BaseEntity {

    /**
     * 用户编号
     */
    protected String userNo;

    /**
     * 用户名

     */
    protected String userName;

    /**
     * 密码
     */
    protected String password;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 状态 0锁定 1有效
     */
    protected String status;


    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", deptId=" + deptId +
                ", status='" + status + '\'' +
                '}';
    }
}