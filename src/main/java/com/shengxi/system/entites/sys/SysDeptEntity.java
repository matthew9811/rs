package com.shengxi.system.entites.sys;

import java.util.Date;

public class SysDeptEntity {
    /**
     * 上级部门id
     */
    private String parent_id;
    /**
     * 部门名称
     */
    private String dept_name;
    /**
     * 排序
     */
    private String sort;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date udpateTime;
    /**
     * 更新人
     */
    private String udpateBy;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除标识
     */
    private String delFlag;

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SysDeptEntity{" +
                "parent_id='" + parent_id + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
