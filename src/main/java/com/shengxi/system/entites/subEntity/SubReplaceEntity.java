package com.shengxi.system.entites.subEntity;

import com.shengxi.rs.common.domain.BaseEntity;

import java.util.Date;
/**
 * @author : 郑杰
 * @Date: 2019/4/26 15:15
 * @Description: 替代课程实体类
 */
public class SubReplaceEntity extends BaseEntity {
    /**
     * 原课程编号
     */
    private String subNo;
    /**
     * 替代课程课程编号
     */
    private String subReplaceNo;
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

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getSubReplaceNo() {
        return subReplaceNo;
    }

    public void setSubReplaceNo(String subReplaceNo) {
        this.subReplaceNo = subReplaceNo;
    }

    @Override
    public String toString() {
        return "SubReplaceEntity{" +
                "subNo='" + subNo + '\'' +
                ", subReplaceNo='" + subReplaceNo + '\'' +
                '}';
    }
}
