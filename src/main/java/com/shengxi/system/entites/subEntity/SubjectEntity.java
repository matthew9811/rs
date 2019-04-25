package com.shengxi.system.entites.subEntity;

import com.shengxi.rs.common.domain.BaseEntity;

import java.util.Date;
/**
 * @author : 郑杰
 * @Date: 2019/4/23 17:13
 * @Description: 课程实体类
 */
public class SubjectEntity extends BaseEntity {
    /**
     * 开课编号
     */
    private String subCarryNo;
    /**
     * 课程编号
     */
    private String subNo;
    /**
     * 课程名称
     */
    private String subName;
    /**
     * 开课院系
     */
    private String subInstitute;
    /**
     * 学分
     */
    private String subredit;
    /**
     * 教学班名称
     */
    private String subClassName;
    /**
     * 已有人数
     */
    private Integer subMenCount;
    /**
     * 总人数
     */
    private Integer subMenTotalCount;
    /**
     * 计划类型
     */
    private String subPlanType;
    /**
     * 总学时
     */
    private Integer subTotalPeriod;
    /**
     * 理论学时
     */
    private Integer subTheoryPeriod;
    /**
     * 实践学时
     */
    private Integer subPracticePeriod;
    /**
     * 老师id
     */
    private String subTeacherId;
    /**
     * 选课类型
     */
    private String subCourseType;
    /**
     * 是否为替代课程
     */
    private String subCourseGenre;
    /**
     * 课程类别
     */
    private String replace;
    /**
     * 课程状态
     */
    private String subStatus;
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

    public String getSubCarryNo() {
        return subCarryNo;
    }

    public void setSubCarryNo(String subCarryNo) {
        this.subCarryNo = subCarryNo;
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

    public String getSubInstitute() {
        return subInstitute;
    }

    public void setSubInstitute(String subInstitute) {
        this.subInstitute = subInstitute;
    }

    public String getSubredit() {
        return subredit;
    }

    public void setSubredit(String subredit) {
        this.subredit = subredit;
    }

    public String getSubClassName() {
        return subClassName;
    }

    public void setSubClassName(String subClassName) {
        this.subClassName = subClassName;
    }

    public Integer getSubMenCount() {
        return subMenCount;
    }

    public void setSubMenCount(Integer subMenCount) {
        this.subMenCount = subMenCount;
    }

    public Integer getSubMenTotalCount() {
        return subMenTotalCount;
    }

    public void setSubMenTotalCount(Integer subMenTotalCount) {
        this.subMenTotalCount = subMenTotalCount;
    }

    public String getSubPlanType() {
        return subPlanType;
    }

    public void setSubPlanType(String subPlanType) {
        this.subPlanType = subPlanType;
    }

    public Integer getSubTotalPeriod() {
        return subTotalPeriod;
    }

    public void setSubTotalPeriod(Integer subTotalPeriod) {
        this.subTotalPeriod = subTotalPeriod;
    }

    public Integer getSubTheoryPeriod() {
        return subTheoryPeriod;
    }

    public void setSubTheoryPeriod(Integer subTheoryPeriod) {
        this.subTheoryPeriod = subTheoryPeriod;
    }

    public Integer getSubPracticePeriod() {
        return subPracticePeriod;
    }

    public void setSubPracticePeriod(Integer subPracticePeriod) {
        this.subPracticePeriod = subPracticePeriod;
    }

    public String getSubTeacherId() {
        return subTeacherId;
    }

    public void setSubTeacherId(String subTeacherId) {
        this.subTeacherId = subTeacherId;
    }

    public String getSubCourseType() {
        return subCourseType;
    }

    public void setSubCourseType(String subCourseType) {
        this.subCourseType = subCourseType;
    }

    public String getSubCourseGenre() {
        return subCourseGenre;
    }

    public void setSubCourseGenre(String subCourseGenre) {
        this.subCourseGenre = subCourseGenre;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "subCarryNo='" + subCarryNo + '\'' +
                ", subNo='" + subNo + '\'' +
                ", subName='" + subName + '\'' +
                ", subInstitute='" + subInstitute + '\'' +
                ", subredit='" + subredit + '\'' +
                ", subClassName='" + subClassName + '\'' +
                ", subMenCount=" + subMenCount +
                ", subMenTotalCount=" + subMenTotalCount +
                ", subPlanType='" + subPlanType + '\'' +
                ", subTotalPeriod=" + subTotalPeriod +
                ", subTheoryPeriod=" + subTheoryPeriod +
                ", subPracticePeriod=" + subPracticePeriod +
                ", subTeacherId='" + subTeacherId + '\'' +
                ", subCourseType='" + subCourseType + '\'' +
                ", subCourseGenre='" + subCourseGenre + '\'' +
                ", replace='" + replace + '\'' +
                ", subStatus='" + subStatus + '\'' +
                '}';
    }
}
