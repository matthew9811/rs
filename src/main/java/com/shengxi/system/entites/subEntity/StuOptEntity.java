package com.shengxi.system.entites.subEntity;

import com.shengxi.rs.common.domain.BaseEntity;

import java.util.Date;
/**
 * @author : 郑杰
 * @Date: 2019/4/26 15:08
 * @Description: 学生-已选重修实体类
 */
public class StuOptEntity extends BaseEntity {
    /**
     * 学号
     */
    private String stuNo;
    /**
     * 课程id
     */
    private String subId;
    /**
     * 课程名称
     */
    private String subName;
    /**
     * 审核状态
     */
    private String status;
    /**
     * 开课学院备注
     */
    private String instituteRemark;
    /**
     * 教务部备注
     */
    private String academicRemark;
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

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstituteRemark() {
        return instituteRemark;
    }

    public void setInstituteRemark(String instituteRemark) {
        this.instituteRemark = instituteRemark;
    }

    public String getAcademicRemark() {
        return academicRemark;
    }

    public void setAcademicRemark(String academicRemark) {
        this.academicRemark = academicRemark;
    }

    @Override
    public String toString() {
        return "StuOptEntity{" +
                "stuNo='" + stuNo + '\'' +
                ", subId='" + subId + '\'' +
                ", subName='" + subName + '\'' +
                ", status='" + status + '\'' +
                ", instituteRemark='" + instituteRemark + '\'' +
                ", academicRemark='" + academicRemark + '\'' +
                '}';
    }
}