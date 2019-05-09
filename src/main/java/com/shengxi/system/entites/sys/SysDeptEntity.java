package com.shengxi.system.entites.sys;

import com.shengxi.rs.common.domain.BaseEntity;

import java.util.Date;
/**
 * @author : 郑杰
 * @Date: 2019/5/10 00:34
 * @Description: 部门实体类
 */
public class SysDeptEntity extends BaseEntity {
    /**
     * 上级部门id
     */
    private String parentId;
    /**
     * 部门名称
     */
    private String deptName;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
                "parentId='" + parentId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
