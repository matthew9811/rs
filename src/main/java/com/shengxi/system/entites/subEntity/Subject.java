package com.shengxi.system.entites.subEntity;

import java.util.Date;

public class Subject {
    /**
     * id
     */
    private String id;
    /**
     * 开课编号
     */
    private String subOpeningNumber;
    /**
     * 课程编号
     */
    private String subId;
    /**
     * 课程名称
     */
    private String subName;
    /**
     * 开课院系
     */
    private String subBeginsDepart;
    /**
     * 学分
     */
    private String subCredit;
    /**
     * 教学班名称
     */
    private String subClass;
    /**
     * 上课人数
     */
    private String subAttendance;
    /**
     * 计划类型
     */
    private String subPlanning;
    /**
     * 总学时
     */
    private String subTotalHours;
    /**
     * 理论学时
     */
    private String subTheoreticalHours;
    /**
     * 实践学时
     */
    private String subPracticalHours;
    /**
     * 老师
     */
    private String subTeacher;
    /**
     * 选课类型
     */
    private String subCourseType;
    /**
     * 课程类别
     */
    private String subCourseCategory;
    /**
     * 状态
     */
    private String subState;
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

    public String getSubOpeningNumber() {
        return subOpeningNumber;
    }

    public String getSubId() {
        return subId;
    }

    public String getSubName() {
        return subName;
    }

    public String getSubBeginsDepart() {
        return subBeginsDepart;
    }

    public String getSubCredit() {
        return subCredit;
    }

    public String getSubClass() {
        return subClass;
    }

    public String getSubAttendance() {
        return subAttendance;
    }

    public String getSubPlanning() {
        return subPlanning;
    }

    public String getSubTotalHours() {
        return subTotalHours;
    }

    public String getSubTheoreticalHours() {
        return subTheoreticalHours;
    }

    public String getSubPracticalHours() {
        return subPracticalHours;
    }

    public String getSubTeacher() {
        return subTeacher;
    }

    public String getSubCourseType() {
        return subCourseType;
    }

    public String getSubCourseCategory() {
        return subCourseCategory;
    }

    public String getSubState() {
        return subState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Date getUdpateTime() {
        return udpateTime;
    }

    public String getUdpateBy() {
        return udpateBy;
    }

    public String getRemark() {
        return remark;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubOpeningNumber(String subOpeningNumber) {
        this.subOpeningNumber = subOpeningNumber;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setSubBeginsDepart(String subBeginsDepart) {
        this.subBeginsDepart = subBeginsDepart;
    }

    public void setSubCredit(String subCredit) {
        this.subCredit = subCredit;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    public void setSubAttendance(String subAttendance) {
        this.subAttendance = subAttendance;
    }

    public void setSubPlanning(String subPlanning) {
        this.subPlanning = subPlanning;
    }

    public void setSubTotalHours(String subTotalHours) {
        this.subTotalHours = subTotalHours;
    }

    public void setSubTheoreticalHours(String subTheoreticalHours) {
        this.subTheoreticalHours = subTheoreticalHours;
    }

    public void setSubPracticalHours(String subPracticalHours) {
        this.subPracticalHours = subPracticalHours;
    }

    public void setSubTeacher(String subTeacher) {
        this.subTeacher = subTeacher;
    }

    public void setSubCourseType(String subCourseType) {
        this.subCourseType = subCourseType;
    }

    public void setSubCourseCategory(String subCourseCategory) {
        this.subCourseCategory = subCourseCategory;
    }

    public void setSubState(String subState) {
        this.subState = subState;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setUdpateTime(Date udpateTime) {
        this.udpateTime = udpateTime;
    }

    public void setUdpateBy(String udpateBy) {
        this.udpateBy = udpateBy;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", subOpeningNumber='" + subOpeningNumber + '\'' +
                ", subId='" + subId + '\'' +
                ", subName='" + subName + '\'' +
                ", subBeginsDepart='" + subBeginsDepart + '\'' +
                ", subCredit='" + subCredit + '\'' +
                ", subClass='" + subClass + '\'' +
                ", subAttendance='" + subAttendance + '\'' +
                ", subPlanning='" + subPlanning + '\'' +
                ", subTotalHours='" + subTotalHours + '\'' +
                ", subTheoreticalHours='" + subTheoreticalHours + '\'' +
                ", subPracticalHours='" + subPracticalHours + '\'' +
                ", subTeacher='" + subTeacher + '\'' +
                ", subCourseType='" + subCourseType + '\'' +
                ", subCourseCategory='" + subCourseCategory + '\'' +
                ", subState='" + subState + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", udpateTime=" + udpateTime +
                ", udpateBy='" + udpateBy + '\'' +
                ", remark='" + remark + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
