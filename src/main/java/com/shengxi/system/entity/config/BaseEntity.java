package com.shengxi.system.entity.config;

import com.alibaba.excel.metadata.BaseRowModel;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Matthew
 * @Date: 2019/4/7 14:26
 * @Description: 实体集常用信息
 */
@Component
public class BaseEntity extends BaseRowModel implements Serializable {
    /**
     * id
     */
    protected String id;
    /**
     * 生成时间
     */
    protected Date createTime;
    /**
     * 创建人
     */
    protected String createBy;
    /**
     * 更新时间
     */
    protected Date updateTime;
    /**
     * 更新人
     */
    protected String updateBy;
    /**
     * 备注
     */
    protected String remark;
    /**
     * 删除标识
     */
    protected String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
