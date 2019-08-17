package com.shengxi.system.entity.test;

import com.shengxi.system.entity.config.BaseEntity;

/**
 * @author: Matthew
 * @Date: 2019/5/9 16:09
 * @Description:
 */
public class TestStu  extends BaseEntity {
    private String subNo;
    private String subName;
    private String term;
    private Double grade;
    private String choiceStatus;

    public String getChoiceStatus() {
        return choiceStatus;
    }

    public void setChoiceStatus(String choiceStatus) {
        this.choiceStatus = choiceStatus;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
