package com.shengxi.system.entites.subEntity;

import com.shengxi.rs.common.domain.BaseEntity;

import java.util.Date;

/**
 * @author : 郑杰
 * @Date: 2019/4/23 17:20
 * @Description: 已修课程实体类
 */
public class ComSubEntity extends BaseEntity {
    /**
     * 学号
     */
    private String stuNo;
    /**
     * 课程编号
     */
    private String subNo;
    /**
     * 课程名称
     */
    private String subName;
    /**
     * 成绩
     */
    private String score;
    /**
     * 学分
     */
    private String subredit;
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

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSubredit() {
        return subredit;
    }

    public void setSubredit(String subredit) {
        this.subredit = subredit;
    }

    @Override
    public String toString() {
        return "ComSubEntity{" +
                "stuNo='" + stuNo + '\'' +
                ", subNo='" + subNo + '\'' +
                ", subName='" + subName + '\'' +
                ", score='" + score + '\'' +
                ", subredit='" + subredit + '\'' +
                '}';
    }
}
