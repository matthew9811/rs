package com.shengxi.system.entites.stuEntity;

import java.util.Date;

public class Student {
    /**
     * id
     */
    private String id;
    /**
     * 学号
     */
    private String stuId;
    /**
     * 姓名
     */
    private String stuName;
    /**
     * 所在院系
     */
    private String stuBelongDepart;
    /**
     * 专业
     */
    private String stuMajor;
    /**
     * 手机号
     */
    private String stuPhone;
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

    public String getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuBelongDepart() {
        return stuBelongDepart;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public String getStuPhone() {
        return stuPhone;
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

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuBelongDepart(String stuBelongDepart) {
        this.stuBelongDepart = stuBelongDepart;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
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
        return "Student{" +
                "id='" + id + '\'' +
                ", stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuBelongDepart='" + stuBelongDepart + '\'' +
                ", stuMajor='" + stuMajor + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", udpateTime=" + udpateTime +
                ", udpateBy='" + udpateBy + '\'' +
                ", remark='" + remark + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
