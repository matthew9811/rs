package com.shengxi.system.entites;

import javax.persistence.Entity;

/**
 * @author : 郑杰
 * @Date: 2019/3/23 14:25
 * @Description: 学生申请表实体类
 */
@Entity
public class StudentApplicationFormForRehabilitationEntites {
	/**学号*/
    private String studentID;
	/**申请人*/
    private String name;
    /**所在院系*/
    private String facultyAndDepartments;
    /**专业 */
    private String major;
    /**原课程代码*/
    private String originalCourseCode;
    /**原课程名称*/
    private String ofTheOriginalCourse;
    /**原学分*/
    private String originalCredits;
    /**现课程代码 */
    private String currentCourseCode;
    /**现课程名称*/
    private String currentCourseName;
    /**现学分*/
    private String presentCreditHour;
    /**开课学院*/
    private String schoolOfCommencement;
    /**手机号*/
    private String cellPhoneNumber;
    
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFacultyAndDepartments() {
		return facultyAndDepartments;
	}
	public void setFacultyAndDepartments(String facultyAndDepartments) {
		this.facultyAndDepartments = facultyAndDepartments;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getOriginalCourseCode() {
		return originalCourseCode;
	}
	public void setOriginalCourseCode(String originalCourseCode) {
		this.originalCourseCode = originalCourseCode;
	}
	public String getOfTheOriginalCourse() {
		return ofTheOriginalCourse;
	}
	public void setOfTheOriginalCourse(String ofTheOriginalCourse) {
		this.ofTheOriginalCourse = ofTheOriginalCourse;
	}
	public String getOriginalCredits() {
		return originalCredits;
	}
	public void setOriginalCredits(String originalCredits) {
		this.originalCredits = originalCredits;
	}
	public String getCurrentCourseCode() {
		return currentCourseCode;
	}
	public void setCurrentCourseCode(String currentCourseCode) {
		this.currentCourseCode = currentCourseCode;
	}
	public String getCurrentCourseName() {
		return currentCourseName;
	}
	public void setCurrentCourseName(String currentCourseName) {
		this.currentCourseName = currentCourseName;
	}
	public String getPresentCreditHour() {
		return presentCreditHour;
	}
	public void setPresentCreditHour(String presentCreditHour) {
		this.presentCreditHour = presentCreditHour;
	}
	public String getSchoolOfCommencement() {
		return schoolOfCommencement;
	}
	public void setSchoolOfCommencement(String schoolOfCommencement) {
		this.schoolOfCommencement = schoolOfCommencement;
	}
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	@Override
	public String toString() {
		return "StudentApplicationFormForRehabilitationEntites [studentID=" + studentID + ", name=" + name
				+ ", facultyAndDepartments=" + facultyAndDepartments + ", major=" + major + ", originalCourseCode="
				+ originalCourseCode + ", ofTheOriginalCourse=" + ofTheOriginalCourse + ", originalCredits="
				+ originalCredits + ", currentCourseCode=" + currentCourseCode + ", currentCourseName="
				+ currentCourseName + ", presentCreditHour=" + presentCreditHour + ", schoolOfCommencement="
				+ schoolOfCommencement + ", cellPhoneNumber=" + cellPhoneNumber + "]";
	}
        
}
