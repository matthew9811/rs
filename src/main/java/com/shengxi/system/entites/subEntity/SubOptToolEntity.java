package com.shengxi.system.entites.subEntity;

import com.shengxi.rs.common.domain.BaseEntity;

public class SubOptToolEntity extends BaseEntity {
    /**
     * 学号
     */
    private String stuNo;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 班级
     */
    private String subClass;
    /**
     * 专业
     */
    private String major;
    /**
     * 所属学院
     */
    private String subordinate;
    /**
     * 开课学院
     */
    private String institute;
    /**
     * 原课程代码
     */
    private String originalSubNo;
    /**
     * 原课程名称
     */
    private String originalSubName;
    /**
     * 原学分
     */
    private String originalSubCredit;
    /**
     * 现课程代码
     */
    private String nowSubNo;
    /**
     * 现课程名称
     */
    private String nowSubName;
    /**
     * 现学分
     */
    private String nowSubCredit;
    /**
     * 开课编号
     */
    private String subCarryNo;
    /**
     * 教学班级
     */
    private String subClassName;

    /**
     *审核状态
     */
    private String status;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(String subordinate) {
        this.subordinate = subordinate;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getOriginalSubNo() {
        return originalSubNo;
    }

    public void setOriginalSubNo(String originalSubNo) {
        this.originalSubNo = originalSubNo;
    }

    public String getOriginalSubName() {
        return originalSubName;
    }

    public void setOriginalSubName(String originalSubName) {
        this.originalSubName = originalSubName;
    }

    public String getOriginalSubCredit() {
        return originalSubCredit;
    }

    public void setOriginalSubCredit(String originalSubCredit) {
        this.originalSubCredit = originalSubCredit;
    }

    public String getNowSubNo() {
        return nowSubNo;
    }

    public void setNowSubNo(String nowSubNo) {
        this.nowSubNo = nowSubNo;
    }

    public String getNowSubName() {
        return nowSubName;
    }

    public void setNowSubName(String nowSubName) {
        this.nowSubName = nowSubName;
    }

    public String getNowSubCredit() {
        return nowSubCredit;
    }

    public void setNowSubCredit(String nowSubCredit) {
        this.nowSubCredit = nowSubCredit;
    }

    public String getSubCarryNo() {
        return subCarryNo;
    }

    public void setSubCarryNo(String subCarryNo) {
        this.subCarryNo = subCarryNo;
    }

    public String getSubClassName() {
        return subClassName;
    }

    public void setSubClassName(String subClassName) {
        this.subClassName = subClassName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubOptToolEntity{" +
                "stuNo='" + stuNo + '\'' +
                ", userName='" + userName + '\'' +
                ", subClass='" + subClass + '\'' +
                ", major='" + major + '\'' +
                ", subordinate='" + subordinate + '\'' +
                ", institute='" + institute + '\'' +
                ", originalSubNo='" + originalSubNo + '\'' +
                ", originalSubName='" + originalSubName + '\'' +
                ", originalSubCredit='" + originalSubCredit + '\'' +
                ", nowSubNo='" + nowSubNo + '\'' +
                ", nowSubName='" + nowSubName + '\'' +
                ", nowSubCredit='" + nowSubCredit + '\'' +
                ", subCarryNo='" + subCarryNo + '\'' +
                ", subClassName='" + subClassName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
