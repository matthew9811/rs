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
	/**开课编号*/
	private String openingNumbe;
	/**教学班级*/
	private String teachingClass;

	public String getStudentID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

	public String getFacultyAndDepartments() {
		return facultyAndDepartments;
	}

	public String getMajor() {
		return major;
	}

	public String getOriginalCourseCode() {
		return originalCourseCode;
	}

	public String getOfTheOriginalCourse() {
		return ofTheOriginalCourse;
	}

	public String getOriginalCredits() {
		return originalCredits;
	}

	public String getCurrentCourseCode() {
		return currentCourseCode;
	}

	public String getCurrentCourseName() {
		return currentCourseName;
	}

	public String getPresentCreditHour() {
		return presentCreditHour;
	}

	public String getSchoolOfCommencement() {
		return schoolOfCommencement;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public String getOpeningNumbe() {
		return openingNumbe;
	}

	public String getTeachingClass() {
		return teachingClass;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFacultyAndDepartments(String facultyAndDepartments) {
		this.facultyAndDepartments = facultyAndDepartments;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setOriginalCourseCode(String originalCourseCode) {
		this.originalCourseCode = originalCourseCode;
	}

	public void setOfTheOriginalCourse(String ofTheOriginalCourse) {
		this.ofTheOriginalCourse = ofTheOriginalCourse;
	}

	public void setOriginalCredits(String originalCredits) {
		this.originalCredits = originalCredits;
	}

	public void setCurrentCourseCode(String currentCourseCode) {
		this.currentCourseCode = currentCourseCode;
	}

	public void setCurrentCourseName(String currentCourseName) {
		this.currentCourseName = currentCourseName;
	}

	public void setPresentCreditHour(String presentCreditHour) {
		this.presentCreditHour = presentCreditHour;
	}

	public void setSchoolOfCommencement(String schoolOfCommencement) {
		this.schoolOfCommencement = schoolOfCommencement;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public void setOpeningNumbe(String openingNumbe) {
		this.openingNumbe = openingNumbe;
	}

	public void setTeachingClass(String teachingClass) {
		this.teachingClass = teachingClass;
	}

	@Override
	public String toString() {
		return "StudentApplicationFormForRehabilitationEntites{" +
				"studentID='" + studentID + '\'' +
				", name='" + name + '\'' +
				", facultyAndDepartments='" + facultyAndDepartments + '\'' +
				", major='" + major + '\'' +
				", originalCourseCode='" + originalCourseCode + '\'' +
				", ofTheOriginalCourse='" + ofTheOriginalCourse + '\'' +
				", originalCredits='" + originalCredits + '\'' +
				", currentCourseCode='" + currentCourseCode + '\'' +
				", currentCourseName='" + currentCourseName + '\'' +
				", presentCreditHour='" + presentCreditHour + '\'' +
				", schoolOfCommencement='" + schoolOfCommencement + '\'' +
				", cellPhoneNumber='" + cellPhoneNumber + '\'' +
				", openingNumbe='" + openingNumbe + '\'' +
				", teachingClass='" + teachingClass + '\'' +
				'}';
	}
}
