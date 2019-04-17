package com.shengxi.rs.common.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Matthew
 * @Date: 2019/4/7 14:26
 * @Description: 实体集常用信息
 */
@Component
public class BaseEntity implements Serializable {
    /**
     * id
     */
    private String id;
    /**
     * 生成时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;
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

    public Date getUdpateTime() {
        return udpateTime;
    }

    public void setUdpateTime(Date udpateTime) {
        this.udpateTime = udpateTime;
    }

    public String getUdpateBy() {
        return udpateBy;
    }

    public void setUdpateBy(String udpateBy) {
        this.udpateBy = udpateBy;
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


    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", udpateTime=" + udpateTime +
                ", udpateBy='" + udpateBy + '\'' +
                ", remark='" + remark + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
