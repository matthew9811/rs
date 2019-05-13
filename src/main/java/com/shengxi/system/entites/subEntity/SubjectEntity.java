package com.shengxi.system.entites.subEntity;

import com.shengxi.rs.common.domain.BaseEntity;

import com.shengxi.system.entites.sys.SysUser;
import java.util.Date;
/**
 * @author : 郑杰
 * @Date: 2019/4/23 17:13
 * @Description: 课程实体类
 */
public class SubjectEntity extends BaseEntity {
    /**
     * id
     */
    private String id;
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
    private String subCredit;
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
     * 课程类别
     */
    private String subCourseGenre;
    /**
     * 是否为替代课程
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

    /**
     * 上课周次
     */
    private String subWeek;

    /**
     * 上课地点
     */
    private String subAddress;

    /**
     * 上课星期几
     */
    private String subWeekDay;

    /**
     * 上课节次
     */
    private String subPeriod;

    private SysUser sysUser;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

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

    public String getSubCredit() {
        return subCredit;
    }

    public void setSubCredit(String subCredit) {
        this.subCredit = subCredit;
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

    public String getSubWeek() {
        return subWeek;
    }

    public void setSubWeek(String subWeek) {
        this.subWeek = subWeek;
    }

    public String getSubAddress() {
        return subAddress;
    }

    public void setSubAddress(String subAddress) {
        this.subAddress = subAddress;
    }

    public String getSubWeekDay() {
        return subWeekDay;
    }

    public void setSubWeekDay(String subWeekDay) {
        this.subWeekDay = subWeekDay;
    }

    public String getSubPeriod() {
        return subPeriod;
    }

    public void setSubPeriod(String subPeriod) {
        this.subPeriod = subPeriod;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id='" + id + '\'' +
                ", subCarryNo='" + subCarryNo + '\'' +
                ", subNo='" + subNo + '\'' +
                ", subName='" + subName + '\'' +
                ", subInstitute='" + subInstitute + '\'' +
                ", subCredit='" + subCredit + '\'' +
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
