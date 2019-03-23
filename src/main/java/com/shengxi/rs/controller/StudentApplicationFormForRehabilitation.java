package com.shengxi.rs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shengxi.system.entites.StudentApplicationFormForRehabilitationEntites;


@Controller
public class StudentApplicationFormForRehabilitation {
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getuser(
			@RequestParam("studentID") String studentID,
			@RequestParam("name") String name,
			@RequestParam("facultyAndDepartments") String facultyAndDepartments,
			@RequestParam("originalCourseCode") String originalCourseCode,
			@RequestParam("nameOfTheOriginalCourse") String ofTheOriginalCourse,
			@RequestParam("originalCredits") String originalCredits,
			@RequestParam("currentCourseCode") String currentCourseCode,
			@RequestParam("currentCourseName") String currentCourseName,
			@RequestParam("presentCreditHour") String presentCreditHour,
			@RequestParam("schoolOfCommencement") String schoolOfCommencement,
			@RequestParam("cellPhoneNumber") String cellPhoneNumber,
			@RequestParam("major") String major,
			HttpSession session){
		StudentApplicationFormForRehabilitationEntites studentApplicationFormForRehabilitationEntites = new StudentApplicationFormForRehabilitationEntites();
		studentApplicationFormForRehabilitationEntites.setStudentID(studentID);
		studentApplicationFormForRehabilitationEntites.setCellPhoneNumber(cellPhoneNumber);
		studentApplicationFormForRehabilitationEntites.setCurrentCourseCode(currentCourseCode);
		studentApplicationFormForRehabilitationEntites.setCurrentCourseName(currentCourseName);
		studentApplicationFormForRehabilitationEntites.setFacultyAndDepartments(facultyAndDepartments);
		studentApplicationFormForRehabilitationEntites.setName(currentCourseName);
		studentApplicationFormForRehabilitationEntites.setOfTheOriginalCourse(ofTheOriginalCourse);
		studentApplicationFormForRehabilitationEntites.setOriginalCourseCode(originalCourseCode);
		studentApplicationFormForRehabilitationEntites.setOriginalCredits(originalCredits);
		studentApplicationFormForRehabilitationEntites.setPresentCreditHour(presentCreditHour);
		studentApplicationFormForRehabilitationEntites.setSchoolOfCommencement(schoolOfCommencement);
		studentApplicationFormForRehabilitationEntites.setMajor(major);
		System.out.println(studentApplicationFormForRehabilitationEntites.toString());
		session.setAttribute("studentApplicationFormForRehabilitationEntites",studentApplicationFormForRehabilitationEntites);
	
	}
	*/
}
