<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>广东东软学院学生申请重修表</title>
</head>
<body>
<form action="" method="post">
  <table border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <th width="111"><p align="center">申请人 </p></th>
      <td colspan="2"><input id="name" name="name" type="text"  style="width:100%;padding:17px"/></td>
      <th width="157"><p align="center">学号 </p></th>
      <td colspan="2"><input id="studentID" name="studentID" type="text"  style="width:100%;padding:17px"/></td>
    </tr>
    <tr>
      <td width="111"><p align="center">所在院系 </p></td>
      <td colspan="2"><input id="facultyAndDepartments" name="facultyAndDepartments" type="text"  style="width:100%;padding:17px"/></td>
      <td width="157"><p align="center">专业 </p></td>
      <td colspan="2"><input id="major" name="major" type="text"  style="width:100%;padding:17px"/></td>
    </tr>
    <tr>
      <td width="111"><p align="center">原课程代码 </p></td>
      <td width="79"><input id="originalCourseCode" name="originalCourseCode" type="text" style="padding:17px"/></td>
      <td width="92"><p align="center">原课程名称 </p></td>
      <td width="157"><input id="ofTheOriginalCourse" name="ofTheOriginalCourse" type="text" style="padding:17px"/></td>
      <td width="76"><p align="center">原学分 </p></td>
      <td width="105"><input id="originalCredits" name="originalCredits" type="text" style="padding:17px"/></td>
    </tr>
    <tr>
      <td width="111"><p align="center">现课程代码 </p></td>
      <td width="79"><input id="currentCourseCode" name="currentCourseCode" type="text" style="padding:17px"/></td>
      <td width="92"><p align="center">现课程名称 </p></td>
      <td width="157"><input id="currentCourseName" name="currentCourseName" type="text" style="padding:17px"/></td>
      <td width="76"><p align="center">现学分 </p></td>
      <td width="105"><input id="presentCreditHour" name="presentCreditHour" type="text" style="padding:17px"/></td>
    </tr>
    <tr>
      <td width="111"><p align="center">开课学院 </p></td>
      <td colspan="2"><input id="schoolOfCommencement" name="schoolOfCommencement" type="text"  style="width:100%;padding:17px"/></td>
      <td width="157"><p align="center">手机号 </p></td>
      <td colspan="2"><input id="cellPhoneNumber" name="cellPhoneNumber" type="text"  style="width:100%;padding:17px"/></td>
    </tr>
	<tr>
            <td colspan="6" align="center" width="268"><input type="submit" value="提交"/>&nbsp;
                <input type="reset" value="重置"/></td>
    </tr>
  </table>
  </form>
</body>
</html>